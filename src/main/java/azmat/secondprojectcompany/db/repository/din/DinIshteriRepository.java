package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.DinIshteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinIshteriRepository extends JpaRepository<DinIshteri, Long> {
}