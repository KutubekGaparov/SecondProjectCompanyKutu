package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.NewsAnnouncement;
import org.springframework.http.ResponseEntity;

public interface NewsAnnouncementService {
    NewsAnnouncement saveNewsAnnouncement(NewsAnnouncement newsAnnouncement);

    NewsAnnouncement update(NewsAnnouncement newsAnnouncement, Long id);

    ResponseEntity<?> deleteById(Long id);
}
