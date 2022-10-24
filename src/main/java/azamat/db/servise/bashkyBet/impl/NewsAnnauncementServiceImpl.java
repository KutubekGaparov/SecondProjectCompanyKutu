package azamat.db.servise.bashkyBet.impl;

import azamat.FileInformation.*;
import azamat.db.repository.bashkyBet.NewsAnnouncementRepository;
import azamat.db.servise.bashkyBet.NewsAnnouncementService;
import azamat.exceptions.BadRequestException;
import azamat.db.model.NewsAnnouncement;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import static azamat.FileInformation.AnnouncementEnum.NEWSOFTHEWORLD;

@Service
@AllArgsConstructor
public class NewsAnnauncementServiceImpl implements NewsAnnouncementService {

    private NewsAnnouncementRepository repository;
    private final AmazonS3Client awsS3Client;

    @Override
    public LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id) {

        NewsAnnouncement byId = repository.getById(id);

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
    public NewsAnnouncement saveNewsAnnouncement(NewsAnnouncement newsAnnouncement) {
        FileInformation newFileInformation = new FileInformation();
        newsAnnouncement.setFileInformation(newFileInformation);
        return repository.save(newsAnnouncement);
    }

    @Override
    @Transactional
    public NewsAnnouncement update(NewsAnnouncement newsAnnouncement, Long id) {
        NewsAnnouncement newsAnnouncement1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = newsAnnouncement1.getText();
        String newText = newsAnnouncement.getText();
        if (!oldText.equals(newText)) {
            newsAnnouncement1.setText(newText);
        }
        String oldText2 = newsAnnouncement1.getDateOfNewAnnouncement();
        String newText2 = newsAnnouncement.getDateOfNewAnnouncement();
        if (!oldText2.equals(newText2)) {
            newsAnnouncement1.setDateOfNewAnnouncement(newText2);
        }
        String oldText22 = newsAnnouncement1.getTitle();
        String newText22 = newsAnnouncement.getTitle();
        if (!oldText22.equals(newText22)) {
            newsAnnouncement1.setTitle(newText22);
        }

        return repository.save(newsAnnouncement1);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<NewsAnnouncement> getAllStateNews(int offset, int pageSize) {
        List<NewsAnnouncement> books = repository.findAllBySort(AnnouncementEnum.STATENEWS);


        Pageable paging = PageRequest.of(offset, pageSize);
        int start = Math.min((int) paging.getOffset(), books.size());
        int end = Math.min((start + paging.getPageSize()), books.size());
        Page<NewsAnnouncement> pages = new PageImpl<>(books.subList(start, end), paging, books.size());
        System.out.println(new CustomPageRequest<>(pages).getContent().size());

        return new CustomPageRequest<>(pages).getContent();
    }

    @Override
    public List<NewsAnnouncement> getAllNewsOfTheWorld(int offset, int pageSize) {

        List<NewsAnnouncement> books = repository.findAllBySort(NEWSOFTHEWORLD);

        Pageable paging = PageRequest.of(offset, pageSize);
        int start = Math.min((int) paging.getOffset(), books.size());
        int end = Math.min((start + paging.getPageSize()), books.size());
        Page<NewsAnnouncement> pages = new PageImpl<>(books.subList(start, end), paging, books.size());
        System.out.println(new CustomPageRequest<>(pages).getContent().size());

        return new CustomPageRequest<>(pages).getContent();
    }

    @Override
    public CountOfPage getCountOfPage() {
      List<NewsAnnouncement> newsAnnouncements = repository.findAll();
      Integer integer = newsAnnouncements.size();
      CountOfPage count = new CountOfPage();
      count.setCountOfPage(countOfPages(integer));
      count.setAll(integer);
      return count;
    }

    public Integer countOfPages(Integer books) {
        int count = 1;
        int size = books;
        for (int i = 0; i < size; i++) {
            if (size - 8 >= 0) {
                size -= 8;
                count++;
            }
        }
        return count;
    }
}
