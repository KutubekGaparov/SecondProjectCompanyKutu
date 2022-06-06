package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.DEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DEventsRepository extends JpaRepository<DEvents, Long> {
}