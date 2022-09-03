package azamat.db.repository.din;

import azamat.db.model.entity.din.Mechitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechitterRepository extends JpaRepository<Mechitter, Long> {
}