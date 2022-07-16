package azamat.db.repository.din;

import azamat.model.entity.din.DEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DEventsRepository extends JpaRepository<DEvents, Long> {
}