package azamat.db.servise.bilimBeruu.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.bilimPeruu.DrivingSchoolRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.bilimBeruu.DrivingSchool;
import azamat.db.servise.bilimBeruu.DrivingSchoolService;
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
public class DrivingSchoolServiceImpl implements DrivingSchoolService {

    private DrivingSchoolRepository drivingSchoolRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        DrivingSchool byId = drivingSchoolRepository.getById(id);

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

        drivingSchoolRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public DrivingSchool saveDrivingSchool(DrivingSchool drivingSchool) {
        FileInformation newFileInformation = new FileInformation();
        drivingSchool.setFileInformation(newFileInformation);
        return drivingSchoolRepository.save(drivingSchool);
    }

    @Override
    @Transactional
    public DrivingSchool update(DrivingSchool drivingSchool, Long id) {
        DrivingSchool drivingSchool1 = drivingSchoolRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = drivingSchool.getDirector();
        String newText = drivingSchool1.getDirector();
        if (!oldText.equals(newText)) {
            drivingSchool1.setDirector(newText);
        }
          String oldText2 = drivingSchool.getPhoneNumber();
        String newText2 = drivingSchool1.getPhoneNumber();
        if (!oldText2.equals(newText2)) {
            drivingSchool1.setPhoneNumber(newText2);
        }
          String oldText1 = drivingSchool.getDrivingCourseName();
        String newText1 = drivingSchool1.getDrivingCourseName();
        if (!oldText1.equals(newText1)) {
            drivingSchool1.setDrivingCourseName(newText1);
        }

        return drivingSchool1;
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        drivingSchoolRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<DrivingSchool> getAll() {
        return drivingSchoolRepository.findAll();
    }
}
