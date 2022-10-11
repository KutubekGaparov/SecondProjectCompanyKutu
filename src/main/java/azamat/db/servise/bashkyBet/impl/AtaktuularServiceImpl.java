package azamat.db.servise.bashkyBet.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.model.Ataktuular;
import azamat.db.repository.bashkyBet.AtaktuularRepository;
import azamat.db.servise.bashkyBet.AtaktuularService;
import azamat.exceptions.BadRequestException;
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
import java.util.UUID;

@Service
@AllArgsConstructor
public class AtaktuularServiceImpl implements AtaktuularService {

    private AtaktuularRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public Ataktuular save(Ataktuular ataktuular) {
        FileInformation newFileInformation = new FileInformation();
        ataktuular.setFileInformation(newFileInformation);
        return repository.save(ataktuular);
    }

    @Override
    @Transactional
    public Ataktuular update(Ataktuular ataktuular1, Long id) {
        Ataktuular ataktuular = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = ataktuular.getInfo();
        String newText = ataktuular1.getInfo();
        if (!oldText.equals(newText)) {
            ataktuular1.setInfo(newText);
        }

        String oldText1 = ataktuular.getBirthday();
        String newText1 = ataktuular1.getBirthday();
        if (!oldText1.equals(newText1)) {
            ataktuular1.setBirthday(newText1);
        }

        String oldText2 = ataktuular.getFullName();
        String newText2 = ataktuular1.getFullName();
        if (!oldText2.equals(newText2)) {
            ataktuular1.setFullName(newText2);
        }

        return repository.save(ataktuular);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }


    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        Ataktuular byId = repository.getById(id);

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
}
