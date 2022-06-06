package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.Ataktuular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtaktuularRepository extends JpaRepository<Ataktuular, Long> {
}