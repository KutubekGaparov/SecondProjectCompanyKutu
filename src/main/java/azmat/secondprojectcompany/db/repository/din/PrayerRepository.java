package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.Prayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrayerRepository extends JpaRepository<Prayer, Long> {
}