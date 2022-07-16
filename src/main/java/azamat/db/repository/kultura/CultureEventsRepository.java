package azamat.db.repository.kultura;

import azamat.model.entity.Kultura.CultureEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureEventsRepository extends JpaRepository<CultureEvents, Long> {
}