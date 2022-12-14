package azamat.db.servise.jashtarIshteri.Impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.jashtarIshteri.SportsEventsRepository;
import azamat.db.servise.jashtarIshteri.SportsEventsService;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.jashtarIshteri.SportsEvents;
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
public class SportsEventsServiceImpl implements SportsEventsService {

    private SportsEventsRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        SportsEvents byId = repository.getById(id);

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
    public SportsEvents saveSportsEvents(SportsEvents sportsEvents) {
        FileInformation newFileInformation = new FileInformation();
        sportsEvents.setFileInformation(newFileInformation);
        return repository.save(sportsEvents);
    }

    @Override
    @Transactional
    public SportsEvents update(SportsEvents sportsEvents, Long id) {
        SportsEvents circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getSportEventsName();
        String newText = sportsEvents.getSportEventsName();
        if (!oldText.equals(newText)) {
            circles1.setSportEventsName(newText);
        }
        String oldText1 = circles1.getAddress();
        String newText1 = sportsEvents.getAddress();
        if (!oldText1.equals(newText1)) {
            circles1.setAddress(newText1);
        }
        String oldText2 = circles1.getTime();
        String newText2 = sportsEvents.getTime();
        if (!oldText2.equals(newText2)) {
            circles1.setTime(newText2);
        }
          String oldText22 = circles1.getInfo();
        String newText22 = sportsEvents.getInfo();
        if (!oldText22.equals(newText22)) {
            circles1.setInfo(newText22);
        }

        return repository.save(circles1);
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<SportsEvents> getAll() {
        return repository.findAll();
    }
}
