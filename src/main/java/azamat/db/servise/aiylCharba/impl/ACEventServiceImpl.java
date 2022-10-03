package azamat.db.servise.aiylCharba.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.model.entity.aiylCharba.ACEvent;
import azamat.db.model.entity.aiylCharba.AnimalHusbandry;
import azamat.db.repository.aiylCharba.ACEventRepository;
import azamat.db.servise.aiylCharba.ACEventService;
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
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ACEventServiceImpl implements ACEventService {

    private ACEventRepository acEventRepository;
    private final AmazonS3Client awsS3Client;


    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        ACEvent byId = acEventRepository.getById(id);

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

        acEventRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }


    @Override
    public ACEvent saveAsEvent(ACEvent acEvent) {
        FileInformation newFileInformation = new FileInformation();
        acEvent.setFileInformation(newFileInformation);
        return acEventRepository.save(acEvent);
    }

    @Override
    @Transactional
    public ACEvent update(ACEvent acEvent,Long id) {
        ACEvent acEvent1 = acEventRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = acEvent1.getText();
        String newText = acEvent.getText();
        if (!oldText.equals(newText)) {
            acEvent1.setText(newText);
        }
        String oldText1 = acEvent1.getTitle();
        String newText1 = acEvent.getTitle();
        if (!oldText1.equals(newText1)) {
            acEvent1.setTitle(newText1);
        }

        return acEventRepository.save(acEvent1);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
         acEventRepository.deleteById(id);
         return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<ACEvent> getAll() {
        return acEventRepository.findAll();
    }

}
