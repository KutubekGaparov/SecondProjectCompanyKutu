package azamat.db.repository.bashkyBet;

import azamat.db.model.Kyzmatkerler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KyzmatkerlerRepository extends JpaRepository<Kyzmatkerler, Long> {
}