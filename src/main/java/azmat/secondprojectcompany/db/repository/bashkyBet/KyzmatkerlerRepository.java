package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.Kyzmatkerler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KyzmatkerlerRepository extends JpaRepository<Kyzmatkerler, Long> {
}