package azamat.db.servise.bashkyBet;

import azamat.db.model.NewsAnnouncement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface NewsAnnouncementService {
    NewsAnnouncement saveNewsAnnouncement(NewsAnnouncement newsAnnouncement);

    NewsAnnouncement update(NewsAnnouncement newsAnnouncement, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<NewsAnnouncement> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
