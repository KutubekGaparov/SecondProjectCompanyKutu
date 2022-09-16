package azamat.db.servise.aiylCharba.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.aiylCharba.PastureRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.aiylCharba.Pasture;
import azamat.db.servise.aiylCharba.PastureServise;
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
public class PastureServiceImpl implements PastureServise {

    private PastureRepository pastureRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        Pasture byId = pastureRepository.getById(id);

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

        pastureRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }

    @Override
    public Pasture savePasture(Pasture pasture) {
        FileInformation newFileInformation = new FileInformation();
        pasture.setFileInformation(newFileInformation);
        return pastureRepository.save(pasture);
    }

    @Override
    @Transactional
    public Pasture update(Pasture pasture, Long id) {
        Pasture pasture1 = pastureRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = pasture1.getText();
        String newText = pasture.getText();
        if (!oldText.equals(newText)) {
            pasture1.setText(newText);
        }
        String oldName = pasture1.getDirectorFullName();
        String newName = pasture.getDirectorFullName();
        if (!oldName.equals(newName)) {
            pasture1.setDirectorFullName(newName);
        }
        return pasture1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Pasture> getAll() {
        return pastureRepository.findAll();
    }
}
