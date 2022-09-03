package azamat.db.repository.din;

import azamat.db.model.entity.din.Ramazan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamazanRepository extends JpaRepository<Ramazan, Long> {
}