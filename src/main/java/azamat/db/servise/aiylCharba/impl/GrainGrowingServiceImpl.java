package azamat.db.servise.aiylCharba.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.aiylCharba.GrainGrowingRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.aiylCharba.GrainGrowing;
import azamat.db.servise.aiylCharba.GrainGrowingService;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GrainGrowingServiceImpl implements GrainGrowingService{

    private GrainGrowingRepository grainGrowingRepository;

    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        GrainGrowing byId = grainGrowingRepository.getById(id);

        String keyOfFirstPhoto = "Images/" + UUID.randomUUID() + "." + firstPhoto.getOriginalFilename();

        ObjectMetadata metaDataForFirstPhoto = new ObjectMetadata();
        metaDataForFirstPhoto.setContentLength(firstPhoto.getSize());
        metaDataForFirstPhoto.setContentType(firstPhoto.getContentType());

        try {
            awsS3Client.putObject(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto, firstPhoto.getInputStream(), metaDataForFirstPhoto);

        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occurred while uploading the file");
        }
        awsS3Client.setObjectAcl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto, CannedAccessControlList.PublicRead);

        byId.getFileInformation().setKeyOfPhoto(keyOfFirstPhoto);

        byId.getFileInformation().setPhoto(awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        grainGrowingRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }

    @Override
    public GrainGrowing saveGrainGraving(GrainGrowing grainGrowing) {
        FileInformation newFileInformation = new FileInformation();
        grainGrowing.setFileInformation(newFileInformation);
        return grainGrowingRepository.save(grainGrowing);
    }

    @Override
    @Transactional
    public GrainGrowing update(GrainGrowing grainGrowing, Long id) {
        GrainGrowing grainGrowing1 = grainGrowingRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = grainGrowing1.getText();
        String newText = grainGrowing.getText();
        if (!oldText.equals(newText)) {
            grainGrowing1.setText(newText);
        }
        return grainGrowing1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        grainGrowingRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<GrainGrowing> getAll() {
        return grainGrowingRepository.findAll();
    }
}
