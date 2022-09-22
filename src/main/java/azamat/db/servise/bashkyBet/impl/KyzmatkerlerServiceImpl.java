package azamat.db.servise.bashkyBet.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.bashkyBet.KyzmatkerlerRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.Kyzmatkerler;
import azamat.db.servise.bashkyBet.KyzmatkerlerService;
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
public class KyzmatkerlerServiceImpl implements KyzmatkerlerService {

    private KyzmatkerlerRepository kyzmatkerlerRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        Kyzmatkerler byId = kyzmatkerlerRepository.getById(id);

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

        kyzmatkerlerRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }

    @Override
    public Kyzmatkerler saveKyzmatkerler(Kyzmatkerler kyzmatkerler) {
        FileInformation newFileInformation = new FileInformation();
        kyzmatkerler.setFileInformation(newFileInformation);

        if (!kyzmatkerler.getType().equals("1")) {
            kyzmatkerlerRepository.save(kyzmatkerler);
        }
        return kyzmatkerler;
    }

    @Override
    @Transactional
    public Kyzmatkerler update(Kyzmatkerler kyzmatkerler1, Long id) {
        Kyzmatkerler kyzmatkerler = kyzmatkerlerRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = kyzmatkerler.getFirstName();
        String newText = kyzmatkerler1.getFirstName();
        if (!oldText.equals(newText)) {
            kyzmatkerler.setFirstName(newText);
        }
        String oldName = kyzmatkerler.getLastName();
        String newName = kyzmatkerler1.getLastName();
        if (!oldName.equals(newName)) {
            kyzmatkerler.setLastName(newName);
        }
        String oldPatronymic = kyzmatkerler.getPatronymic();
        String newPatronymic = kyzmatkerler1.getPatronymic();
        if (!oldPatronymic.equals(newPatronymic)) {
            kyzmatkerler.setPatronymic(newPatronymic);
        }
        LocalDate oldBirthDay = kyzmatkerler.getBirthDay();
        LocalDate newBirthDay = kyzmatkerler1.getBirthDay();
        if (!Objects.equals(oldBirthDay, newBirthDay)) {
            kyzmatkerler.setBirthDay(newBirthDay);
        }
        String oldPositions = kyzmatkerler.getPositions();
        String newPositions = kyzmatkerler1.getPositions();
        if (!oldPositions.equals(newPositions)) {
            kyzmatkerler.setPatronymic(newPositions);
        }
        String oldEmail = kyzmatkerler.getEmail();
        String newEmail = kyzmatkerler1.getEmail();
        if (!oldEmail.equals(newEmail)) {
            kyzmatkerler.setEmail(newEmail);
        }
        String oldPhone = kyzmatkerler.getPhoneNumber();
        String newPhone = kyzmatkerler1.getPhoneNumber();
        if (!Objects.equals(oldPhone, newPhone)) {
            kyzmatkerler.setPhoneNumber(newPhone);
        }
        String as = kyzmatkerler.getType();
        String asd = kyzmatkerler1.getType();
        if (!Objects.equals(as, asd)) {
            kyzmatkerler.setType(asd);
        }

        return kyzmatkerler;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        kyzmatkerlerRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Kyzmatkerler> getAll() {
        return kyzmatkerlerRepository.findAll();
    }

}
