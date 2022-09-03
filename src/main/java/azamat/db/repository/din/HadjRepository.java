package azamat.db.repository.din;

import azamat.db.model.entity.din.Hadj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HadjRepository extends JpaRepository<Hadj, Long> {
}