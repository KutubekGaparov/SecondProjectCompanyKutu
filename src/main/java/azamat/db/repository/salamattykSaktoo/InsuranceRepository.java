package azamat.db.repository.salamattykSaktoo;

import azamat.model.entity.salamattykSaktoo.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}