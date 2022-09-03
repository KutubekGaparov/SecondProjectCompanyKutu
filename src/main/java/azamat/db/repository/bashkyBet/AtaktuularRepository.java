package azamat.db.repository.bashkyBet;

import azamat.db.model.Ataktuular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtaktuularRepository extends JpaRepository<Ataktuular, Long> {
}