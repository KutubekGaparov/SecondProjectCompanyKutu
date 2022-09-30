package azamat.db.servise.salamattykdySaktoo.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.salamattykSaktoo.MedicalCenter;
import azamat.db.repository.salamattykSaktoo.MedicalCenterRepository;
import azamat.db.servise.salamattykdySaktoo.MedicalCenterService;
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
public class MedicalCenterServiceImpl implements MedicalCenterService {

    private MedicalCenterRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        MedicalCenter byId = repository.getById(id);

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
    public MedicalCenter saveMedicalCenter(MedicalCenter medicalCenter) {
        FileInformation newFileInformation = new FileInformation();
        medicalCenter.setFileInformation(newFileInformation);
        return repository.save(medicalCenter);
    }

    @Override
    @Transactional
    public MedicalCenter update(MedicalCenter medicalCenter, Long id) {
        MedicalCenter circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));


        String oldText = circles1.getAddress();
        String newText = medicalCenter.getAddress();
        if (!oldText.equals(newText)) {
            circles1.setAddress(newText);
        }
        String oldText1 = circles1.getDirectorHospital();
        String newText1 = medicalCenter.getDirectorHospital();
        if (!oldText1.equals(newText1)) {
            circles1.setDirectorHospital(newText1);
        }
        String oldText2 = circles1.getEmail();
        String newText2 = medicalCenter.getEmail();
        if (!oldText2.equals(newText2)) {
            circles1.setEmail(newText2);
        }
        String oldText3 = circles1.getHospitalName();
        String newText3 = medicalCenter.getHospitalName();
        if (!oldText3.equals(newText3)) {
            circles1.setHospitalName(newText3);
        }
        String oldText4 = circles1.getPhoneNumber();
        String newText4 = medicalCenter.getPhoneNumber();
        if (!oldText4.equals(newText4)) {
            circles1.setPhoneNumber(newText4);
        }
        String oldText44 = circles1.getInfo();
        String newText44 = medicalCenter.getInfo();
        if (!oldText44.equals(newText44)) {
            circles1.setInfo(newText44);
        }

        return repository.save(circles1);
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<MedicalCenter> getAll() {
        return repository.findAll();
    }
}
