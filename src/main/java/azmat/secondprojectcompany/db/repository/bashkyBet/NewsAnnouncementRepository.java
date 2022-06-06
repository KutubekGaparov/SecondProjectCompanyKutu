package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.NewsAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsAnnouncementRepository extends JpaRepository<NewsAnnouncement, Long> {
}