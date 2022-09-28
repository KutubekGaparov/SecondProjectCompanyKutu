package azamat.db.servise.bilimBeruu.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.bilimBeruu.Schools;
import azamat.db.repository.bilimPeruu.SchoolsRepository;
import azamat.db.servise.bilimBeruu.SchoolsService;
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
public class SchoolsServiceImpl implements SchoolsService {

    private SchoolsRepository schoolsRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        Schools byId = schoolsRepository.getById(id);

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

        schoolsRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public Schools saveSchools(Schools schools) {
        FileInformation newFileInformation = new FileInformation();
        schools.setFileInformation(newFileInformation);
        return schoolsRepository.save(schools);
    }

    @Override
    @Transactional
    public Schools update(Schools schools, Long id) {
        Schools moeEvent = schoolsRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = moeEvent.getText();
        String newText = schools.getText();
        if (!oldText.equals(newText)) {
            moeEvent.setText(newText);
        }
        String oldName = moeEvent.getSchoolName();
        String newName = schools.getSchoolName();
        if (!oldName.equals(newName)) {
            moeEvent.setSchoolName(newName);
        }
        String oldFullName = moeEvent.getDirectorFullName();
        String newFullName = schools.getDirectorFullName();
        if (!oldFullName.equals(newFullName)) {
            moeEvent.setDirectorFullName(newFullName);
        }
        String oldAddress = moeEvent.getAddress();
        String newAddress = schools.getAddress();
        if (!oldAddress.equals(newAddress)) {
            moeEvent.setAddress(newAddress);
        }
        String oldNum = moeEvent.getPhoneNumber();
        String newNum = schools.getPhoneNumber();
        if (!oldNum.equals(newNum)) {
            moeEvent.setPhoneNumber(newNum);
        }

        return schoolsRepository.save(moeEvent);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        schoolsRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Schools> getAll() {
        return schoolsRepository.findAll();
    }
}
