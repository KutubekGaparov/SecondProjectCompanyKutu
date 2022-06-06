
package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.Ait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AitRepository extends JpaRepository<Ait, Long> {
}