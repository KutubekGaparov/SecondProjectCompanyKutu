package azamat.db.servise.dinService.dinServiceImpl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.din.ReligionSchool;
import azamat.db.repository.din.ReligionSchoolRepository;
import azamat.db.servise.dinService.ReligionSchoolService;
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
public class ReligionSchoolServiceImpl implements ReligionSchoolService {

    private ReligionSchoolRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        ReligionSchool byId = repository.getById(id);

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
    public ReligionSchool saveReligionSchool(ReligionSchool religionSchool) {
        FileInformation newFileInformation = new FileInformation();
        religionSchool.setFileInformation(newFileInformation);
        return repository.save(religionSchool);
    }

    @Override
    @Transactional
    public ReligionSchool update(ReligionSchool religionSchool, Long id) {
        ReligionSchool circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getAddress();
        String newText = religionSchool.getAddress();
        if (!oldText.equals(newText)) {
            circles1.setAddress(newText);
        }
        String oldName = circles1.getSchoolName();
        String newName = religionSchool.getSchoolName();
        if (!oldName.equals(newName)) {
            circles1.setSchoolName(newName);
        }
        String oldName2 = circles1.getDirector();
        String newName2 = religionSchool.getDirector();
        if (!oldName2.equals(newName2)) {
            circles1.setDirector(newName2);
        }
        LocalDate oldName1 = circles1.getDirectorBirthDay();
        LocalDate newName1 = religionSchool.getDirectorBirthDay();
        if (!oldName1.equals(newName1)) {
            circles1.setDirectorBirthDay(newName1);
        }
        String oldName3 = circles1.getEmail();
        String newName3 = religionSchool.getEmail();
        if (!oldName3.equals(newName3)) {
            circles1.setEmail(newName3);
        }


        String oldName6 = circles1.getPhone();
        String newName6 = religionSchool.getPhone();
        if (!oldName6.equals(newName6)) {
            circles1.setPhone(newName6);
        }
        return circles1;
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<ReligionSchool> getAll() {
        return repository.findAll();
    }
}
