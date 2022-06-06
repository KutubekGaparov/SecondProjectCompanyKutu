package azmat.secondprojectcompany.db.repository.bashkyBet;

import azmat.secondprojectcompany.model.entity.JashtarIshteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JashtarIshteriRepository extends JpaRepository<JashtarIshteri, Long> {
}