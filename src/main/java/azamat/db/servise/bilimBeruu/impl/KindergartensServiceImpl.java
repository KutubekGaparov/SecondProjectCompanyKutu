package azamat.db.servise.bilimBeruu.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.bilimPeruu.KindergartensRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.bilimBeruu.Kindergartens;
import azamat.db.servise.bilimBeruu.KindergartensService;
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
public class KindergartensServiceImpl implements KindergartensService {

    private KindergartensRepository kindergartensRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        Kindergartens byId = kindergartensRepository.getById(id);

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

        kindergartensRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public Kindergartens saveKindergartens(Kindergartens kindergartens) {
        FileInformation newFileInformation = new FileInformation();
        kindergartens.setFileInformation(newFileInformation);
        return kindergartensRepository.save(kindergartens);
    }

    @Override
    @Transactional
    public Kindergartens update(Kindergartens kindergartens1, Long id) {
        Kindergartens kindergartens = kindergartensRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = kindergartens.getKindergartensName();
        String newText = kindergartens1.getKindergartensName();
        if (!oldText.equals(newText)) {
            kindergartens.setKindergartensName(newText);
        }
        String oldText1 = kindergartens.getDirectorFullName();
        String newText1 = kindergartens1.getDirectorFullName();
        if (!oldText1.equals(newText1)) {
            kindergartens.setDirectorFullName(newText1);
        }
        String oldText2 = kindergartens.getCountKindergartens();
        String newText2 = kindergartens1.getCountKindergartens();
        if (!oldText2.equals(newText2)) {
            kindergartens.setCountKindergartens(newText2);
        }
        String oldText3 = kindergartens.getLanguage();
        String newText3 = kindergartens1.getLanguage();
        if (!oldText3.equals(newText3)) {
            kindergartens.setLanguage(newText3);
        }
        String oldText4 = kindergartens.getEmail();
        String newText4 = kindergartens1.getEmail();
        if (!oldText4.equals(newText4)) {
            kindergartens.setEmail(newText4);
        }
        String oldText5 = kindergartens.getPhoneNumber();
        String newText5 = kindergartens1.getPhoneNumber();
        if (!oldText5.equals(newText5)) {
            kindergartens.setPhoneNumber(newText5);
        }

        return kindergartensRepository.save(kindergartens);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        kindergartensRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Kindergartens> getAll() {
        return kindergartensRepository.findAll();
    }
}
