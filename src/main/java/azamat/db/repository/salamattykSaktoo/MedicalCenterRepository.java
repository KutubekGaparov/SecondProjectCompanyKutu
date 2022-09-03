package azamat.db.repository.salamattykSaktoo;

import azamat.db.model.entity.salamattykSaktoo.MedicalCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCenterRepository extends JpaRepository<MedicalCenter, Long> {
}