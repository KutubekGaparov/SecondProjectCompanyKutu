package azamat.db.servise.jashtarIshteri.Impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.jashtarIshteri.YouthInitiativesRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.jashtarIshteri.YouthInitiatives;
import azamat.db.servise.jashtarIshteri.YouthInitiativesService;
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
public class YouthInitiativesServiceImpl implements YouthInitiativesService {

    private YouthInitiativesRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        YouthInitiatives byId = repository.getById(id);

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

        repository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public YouthInitiatives saveYouthInitiatives(YouthInitiatives youthInitiatives) {
        FileInformation newFileInformation = new FileInformation();
        youthInitiatives.setFileInformation(newFileInformation);
        return repository.save(youthInitiatives);
    }

    @Override
    @Transactional
    public YouthInitiatives update(YouthInitiatives youthInitiatives, Long id) {
        YouthInitiatives circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getInitiativesName();
        String newText = youthInitiatives.getInitiativesName();
        if (!oldText.equals(newText)) {
            circles1.setInitiativesName(newText);
        }
        String oldText1 = circles1.getInitiativesDirectorName();
        String newText1 = youthInitiatives.getInitiativesDirectorName();
        if (!oldText1.equals(newText1)) {
            circles1.setInitiativesDirectorName(newText1);
        }
        String oldText11 = circles1.getAddress();
        String newText11 = youthInitiatives.getAddress();
        if (!oldText11.equals(newText11)) {
            circles1.setAddress(newText11);
        }
        String oldText12 = circles1.getPhone();
        String newText12 = youthInitiatives.getPhone();
        if (!oldText12.equals(newText12)) {
            circles1.setPhone(newText12);
        }
        String oldText122 = circles1.getInfo();
        String newText122 = youthInitiatives.getInfo();
        if (!oldText122.equals(newText122)) {
            circles1.setInfo(newText122);
        }

        return repository.save(circles1);
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<YouthInitiatives> getAll() {
        return repository.findAll();
    }
}
