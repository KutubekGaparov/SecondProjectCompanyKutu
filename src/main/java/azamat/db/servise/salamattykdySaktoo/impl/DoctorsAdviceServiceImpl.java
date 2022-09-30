package azamat.db.servise.salamattykdySaktoo.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.salamattykSaktoo.DoctorsAdvice;
import azamat.db.repository.salamattykSaktoo.DoctorsAdviceRepository;
import azamat.db.servise.salamattykdySaktoo.DoctorsAdviceService;
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
public class DoctorsAdviceServiceImpl implements DoctorsAdviceService {

    private DoctorsAdviceRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        DoctorsAdvice byId = repository.getById(id);

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
    public DoctorsAdvice saveDoctorsAdvice(DoctorsAdvice doctorsAdvice) {
        FileInformation newFileInformation = new FileInformation();
        doctorsAdvice.setFileInformation(newFileInformation);
        return repository.save(doctorsAdvice);
    }

    @Override
    @Transactional
    public DoctorsAdvice update(DoctorsAdvice doctorsAdvice, Long id) {
        DoctorsAdvice circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getNameDoctors();
        String newText = doctorsAdvice.getNameDoctors();
        if (!oldText.equals(newText)) {
            circles1.setNameDoctors(newText);
        }
           String oldText2 = circles1.getPhone();
        String newText2 = doctorsAdvice.getPhone();
        if (!oldText2.equals(newText2)) {
            circles1.setPhone(newText2);
        }
           String oldText1 = circles1.getInfo();
        String newText1 = doctorsAdvice.getInfo();
        if (!oldText1.equals(newText1)) {
            circles1.setInfo(newText1);
        }

        return repository.save(circles1);
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<DoctorsAdvice> getAll() {
        return repository.findAll();
    }
}
