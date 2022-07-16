package azamat.db.repository.jashtarIshteri;

import azamat.model.entity.jashtarIshteri.SportsEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsEventsRepository extends JpaRepository<SportsEvents, Long> {
}