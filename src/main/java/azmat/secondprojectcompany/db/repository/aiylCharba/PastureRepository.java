package azmat.secondprojectcompany.db.repository.aiylCharba;

import azmat.secondprojectcompany.model.entity.aiylCharba.Pasture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastureRepository extends JpaRepository<Pasture, Long> {
}