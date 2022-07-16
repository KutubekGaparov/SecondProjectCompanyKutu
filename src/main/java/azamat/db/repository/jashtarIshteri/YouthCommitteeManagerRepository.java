package azamat.db.repository.jashtarIshteri;

import azamat.model.entity.jashtarIshteri.YouthCommitteeManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YouthCommitteeManagerRepository extends JpaRepository<YouthCommitteeManager, Long> {
}