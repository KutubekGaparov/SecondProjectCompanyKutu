package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.DEvents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DEventsRepository extends JpaRepository<DEvents, Long> {
}