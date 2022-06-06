package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.Mechitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechitterRepository extends JpaRepository<Mechitter, Long> {
}