package azamat.db.servise.bilimBeruu.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.bilimPeruu.CirclesRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.bilimBeruu.Circles;
import azamat.db.servise.bilimBeruu.CirclesService;
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
public class CirclesServiceImpl implements CirclesService {

    private CirclesRepository circlesRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        Circles byId = circlesRepository.getById(id);

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

        circlesRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public Circles saveCircles(Circles circles) {
        FileInformation newFileInformation = new FileInformation();
        circles.setFileInformation(newFileInformation);
        return circlesRepository.save(circles);
    }

    @Override
    @Transactional
    public Circles update(Circles circles1, Long id) {
        Circles circles = circlesRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles.getInfo();
        String newText = circles1.getInfo();
        if (!oldText.equals(newText)) {
            circles.setInfo(newText);
        }
        String oldText1 = circles.getCourseName();
        String newText1 = circles1.getCourseName();
        if (!oldText1.equals(newText1)) {
            circles.setCourseName(newText1);
        }
        String oldText2 = circles.getCourseTeacher();
        String newText2 = circles1.getCourseTeacher();
        if (!oldText2.equals(newText2)) {
            circles.setCourseTeacher(newText2);
        }
        String oldText3 = circles.getAddress();
        String newText3 = circles1.getAddress();
        if (!oldText3.equals(newText3)) {
            circles.setAddress(newText3);
        }

        return circlesRepository.save(circles);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        circlesRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Circles> getAll() {
        return circlesRepository.findAll();
    }
}
