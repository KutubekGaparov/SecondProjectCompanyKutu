package azamat.db.repository.salamattykSaktoo;

import azamat.model.entity.salamattykSaktoo.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalsRepository extends JpaRepository<Hospitals, Long> {
}