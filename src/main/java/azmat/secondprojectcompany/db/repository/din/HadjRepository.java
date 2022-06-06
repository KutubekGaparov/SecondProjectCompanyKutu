package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.Hadj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HadjRepository extends JpaRepository<Hadj, Long> {
}