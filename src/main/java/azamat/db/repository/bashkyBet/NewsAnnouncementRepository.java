package azamat.db.repository.bashkyBet;

import azamat.FileInformation.AnnouncementEnum;
import azamat.db.model.NewsAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsAnnouncementRepository extends JpaRepository<NewsAnnouncement, Long> {

    @Query("select b from NewsAnnouncement b where b.enumType = ?1")
    List<NewsAnnouncement> findAllBySort(AnnouncementEnum announcementEnum);
}