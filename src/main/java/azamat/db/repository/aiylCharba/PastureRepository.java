package azamat.db.repository.aiylCharba;

import azamat.db.model.entity.aiylCharba.Pasture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastureRepository extends JpaRepository<Pasture, Long> {
}