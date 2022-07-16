package azamat.db.repository.aiylCharba;

import azamat.model.entity.aiylCharba.Tips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<Tips, Long> {
}