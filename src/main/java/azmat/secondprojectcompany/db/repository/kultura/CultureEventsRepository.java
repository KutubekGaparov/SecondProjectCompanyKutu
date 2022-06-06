package azmat.secondprojectcompany.db.repository.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.CultureEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultureEventsRepository extends JpaRepository<CultureEvents, Long> {
}