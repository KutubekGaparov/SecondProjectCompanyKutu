package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.MChS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MChSRepository extends JpaRepository<MChS, Long> {
}