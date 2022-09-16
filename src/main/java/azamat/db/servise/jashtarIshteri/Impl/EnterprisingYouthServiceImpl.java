package azamat.db.servise.jashtarIshteri.Impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.jashtarIshteri.EnterprisingYouthRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.jashtarIshteri.EnterprisingYouth;
import azamat.db.servise.jashtarIshteri.EnterprisingYouthService;
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
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EnterprisingYouthServiceImpl implements EnterprisingYouthService {

    private EnterprisingYouthRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        EnterprisingYouth byId = repository.getById(id);

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
    public EnterprisingYouth saveEnterprisingYouth(EnterprisingYouth enterprisingYouth) {
        FileInformation newFileInformation = new FileInformation();
        enterprisingYouth.setFileInformation(newFileInformation);
        return repository.save(enterprisingYouth);
    }

    @Override
    @Transactional
    public EnterprisingYouth update(EnterprisingYouth enterprisingYouth, Long id) {
        EnterprisingYouth circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getFullName();
        String newText = enterprisingYouth.getFullName();
        if (!oldText.equals(newText)) {
            circles1.setFullName(newText);
        }
        String oldText2 = circles1.getDirection();
        String newText2 = enterprisingYouth.getDirection();
        if (!oldText2.equals(newText2)) {
            circles1.setDirection(newText2);
        }
        String oldText3 = circles1.getResult();
        String newText3 = enterprisingYouth.getResult();
        if (!oldText3.equals(newText3)) {
            circles1.setResult(newText3);
        }
        LocalDate oldText1 = circles1.getAge();
        LocalDate newText1 = enterprisingYouth.getAge();
        if (!oldText1.equals(newText1)) {
            circles1.setAge(newText1);
        }

        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<EnterprisingYouth> getAll() {
        return repository.findAll();
    }
}
