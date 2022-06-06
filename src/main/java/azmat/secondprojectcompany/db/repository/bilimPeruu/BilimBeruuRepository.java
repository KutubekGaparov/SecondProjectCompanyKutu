package azmat.secondprojectcompany.db.repository.bilimPeruu;

import azmat.secondprojectcompany.model.entity.BilimBeruu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilimBeruuRepository extends JpaRepository<BilimBeruu, Long> {
}