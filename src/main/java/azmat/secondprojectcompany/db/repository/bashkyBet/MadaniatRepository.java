package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.entity.Madaniat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MadaniatRepository extends JpaRepository<Madaniat, Long> {
}