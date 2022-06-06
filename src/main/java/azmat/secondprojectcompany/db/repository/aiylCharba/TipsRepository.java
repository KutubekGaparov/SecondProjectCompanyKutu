package azmat.secondprojectcompany.db.repository.aiylCharba;

import azmat.secondprojectcompany.model.entity.aiylCharba.Tips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<Tips, Long> {
}