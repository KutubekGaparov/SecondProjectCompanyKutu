package azamat.db.servise.bashkyBet.impl;

import azamat.FileInformation.FileInformation;
import azamat.FileInformation.BucketName;
import azamat.db.model.Tazalyk;
import azamat.db.repository.bashkyBet.TazalykRepository;
import azamat.db.servise.bashkyBet.TazalykService;
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
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TazalykServiceImpl implements TazalykService {

    private TazalykRepository tazalykRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public Tazalyk saveTazalyk(Tazalyk tazalyk) {
        FileInformation newFileInformation = new FileInformation();
        tazalyk.setFileInformation(newFileInformation);
        return tazalykRepository.save(tazalyk);
    }

    @Override
    @Transactional
    public Tazalyk update(Tazalyk tazalyk, Long id) {
        Tazalyk tazalyk1 = tazalykRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = tazalyk.getFullName();
        String newText = tazalyk1.getFullName();
        if (!oldText.equals(newText)) {
            tazalyk1.setFullName(newText);
        }
        String oldEmail = tazalyk.getEmail();
        String newEmail = tazalyk1.getEmail();
        if (!oldEmail.equals(newEmail)) {
            tazalyk1.setEmail(newEmail);
        }
        String oldPhone = tazalyk.getPhoneNumber();
        String newPhone = tazalyk1.getPhoneNumber();
        if (!Objects.equals(oldPhone, newPhone)) {
            tazalyk1.setPhoneNumber(newPhone);
        }
        LocalDate oldBirthDay = tazalyk.getBirthday();
        LocalDate newBirthDay = tazalyk1.getBirthday();
        if (!oldBirthDay.equals(newBirthDay)) {
            tazalyk1.setBirthday(newBirthDay);
        }


        return tazalykRepository.save(tazalyk1);
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        tazalykRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Tazalyk> getAll() {
        return tazalykRepository.findAll();
    }

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long bookId) {

        Tazalyk bookById = tazalykRepository.getById(bookId);

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

        bookById.getFileInformation().setKeyOfPhoto(keyOfFirstPhoto);

        bookById.getFileInformation().setPhoto(awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        tazalykRepository.save(bookById);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(bookById.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }

}

