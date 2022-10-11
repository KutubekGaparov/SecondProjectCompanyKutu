package azamat.db.servise.aiylCharba.impl;

import azamat.FileInformation.BucketName;
import azamat.FileInformation.FileInformation;
import azamat.db.repository.aiylCharba.AnimalHusbandryRepository;
import azamat.db.servise.aiylCharba.AnimalHusbandryService;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.aiylCharba.AnimalHusbandry;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import lombok.Value;
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
public class AnimalHusbandryServiceImpl implements AnimalHusbandryService {

    private AnimalHusbandryRepository animalHusbandryRepository;

    @Override
    public AnimalHusbandry saveAsEvent(AnimalHusbandry animalHusbandry) {
        FileInformation newFileInformation = new FileInformation();
        animalHusbandry.setFileInformation(newFileInformation);
        return animalHusbandryRepository.save(animalHusbandry);
    }

    @Override
    @Transactional
    public AnimalHusbandry update(AnimalHusbandry animalHusbandry, Long id) {
        AnimalHusbandry animal = animalHusbandryRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = animal.getText();
        String newText = animalHusbandry.getText();
        if (!oldText.equals(newText)) {
            animal.setText(newText);
        }
        return animalHusbandryRepository.save(animal);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        animalHusbandryRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<AnimalHusbandry> getAll() {
        return animalHusbandryRepository.findAll();
    }

    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        AnimalHusbandry byId = animalHusbandryRepository.getById(id);

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

        animalHusbandryRepository.save(byId);

        LinkedHashMap<String, String> response = new LinkedHashMap<>();
        response.put("file information Id ", String.valueOf(byId.getFileInformation().getFileId()));
        response.put("first image", awsS3Client.getResourceUrl(BucketName.AWS_BOOKS.getBucketName(), keyOfFirstPhoto));

        return response;
    }

    @Override
    public void deleteFile(String keyName) {
        final DeleteObjectRequest deleteObjectRequest = new
                DeleteObjectRequest(BucketName.AWS_BOOKS.getBucketName(), keyName);
        awsS3Client.deleteObject(deleteObjectRequest);
    }

    @Transactional
    @Override
    public String deleteFile2(final String fileName) {
        awsS3Client.deleteObject(BucketName.AWS_BOOKS.getBucketName(), fileName);
        animalHusbandryRepository.deleteByName(fileName);
        return "Deleted File: " + fileName;
    }
}
