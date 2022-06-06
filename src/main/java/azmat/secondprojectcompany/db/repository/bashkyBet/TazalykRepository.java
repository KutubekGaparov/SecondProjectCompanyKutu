package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.Tazalyk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TazalykRepository extends JpaRepository<Tazalyk, Long> {
}