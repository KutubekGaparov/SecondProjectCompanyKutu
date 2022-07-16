package azamat.db.repository.bilimPeruu;

import azamat.model.entity.bilimBeruu.ORT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ORTRepository extends JpaRepository<ORT, Long> {
}