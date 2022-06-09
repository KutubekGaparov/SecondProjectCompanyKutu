package azmat.secondprojectcompany.db.servise.bashkyBet.impl;

import azmat.secondprojectcompany.db.servise.bashkyBet.NewsAnnouncementService;
import azmat.secondprojectcompany.model.NewsAnnouncement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewsAnnauncementServiceImpl implements NewsAnnouncementService {
    @Override
    public NewsAnnouncement saveNewsAnnouncement(NewsAnnouncement newsAnnouncement) {
        return null;
    }

    @Override
    public NewsAnnouncement update(NewsAnnouncement newsAnnouncement, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
