package azamat.db.repository.aiylCharba;

import azamat.model.entity.aiylCharba.Pasture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastureRepository extends JpaRepository<Pasture, Long> {
}