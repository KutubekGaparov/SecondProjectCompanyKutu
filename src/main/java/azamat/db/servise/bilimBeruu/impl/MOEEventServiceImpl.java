package azamat.db.servise.bilimBeruu.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.bilimPeruu.MOEEventRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.bilimBeruu.MOEEvent;
import azamat.db.servise.bilimBeruu.MOEEventService;
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
public class MOEEventServiceImpl implements MOEEventService {

    private MOEEventRepository moeEventRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        MOEEvent byId = moeEventRepository.getById(id);

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

        moeEventRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public MOEEvent saveEvent(MOEEvent event) {
        FileInformation newFileInformation = new FileInformation();
        event.setFileInformation(newFileInformation);
        return moeEventRepository.save(event);
    }

    @Override
    @Transactional
    public MOEEvent update(MOEEvent event, Long id) {
        MOEEvent moeEvent = moeEventRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = moeEvent.getText();
        String newText = event.getText();
        if (!oldText.equals(newText)) {
            moeEvent.setText(newText);
        }
        String oldText1 = moeEvent.getTitle();
        String newText1 = event.getTitle();
        if (!oldText1.equals(newText1)) {
            moeEvent.setTitle(newText1);
        }

        return moeEventRepository.save(moeEvent);
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        moeEventRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<MOEEvent> getAll() {
        return moeEventRepository.findAll();
    }
}
