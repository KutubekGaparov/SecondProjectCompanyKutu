package azamat.db.servise.bashkyBet.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.bashkyBet.MChSRepository;
import azamat.db.servise.bashkyBet.MChSService;
import azamat.exceptions.BadRequestException;
import azamat.db.model.MChS;
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
public class MChSServiceImpl implements MChSService {

    private MChSRepository mChSRepository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        MChS byId =  mChSRepository.getById(id);

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

        mChSRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }
    @Override
    public MChS saveEvent(MChS mChS) {
        FileInformation newFileInformation = new FileInformation();
        mChS.setFileInformation(newFileInformation);
        return mChSRepository.save(mChS);
    }

    @Override
    @Transactional
    public MChS update(MChS mChS, Long id) {
        MChS mChS1 = mChSRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = mChS1.getFullName();
        String newText = mChS.getFullName();
        if (!oldText.equals(newText)) {
            mChS1.setFullName(newText);
        }
        String oldEmail = mChS.getEmail();
        String newEmail = mChS.getEmail();
        if (!oldEmail.equals(newEmail)) {
            mChS1.setEmail(newEmail);
        }
        String oldPhone = mChS.getPhone();
        String newPhone = mChS1.getPhone();
        if (!Objects.equals(oldPhone, newPhone)) {
            mChS1.setPhone(newPhone);
        }
        LocalDate oldBirthDay = mChS.getBirthDay();
        LocalDate newBirthDay = mChS1.getBirthDay();
        if (!oldBirthDay.equals(newBirthDay)) {
            mChS1.setBirthDay(newBirthDay);
        }

        return mChSRepository.save(mChS1);
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        mChSRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<MChS> getAll() {
        return mChSRepository.findAll();
    }
}
