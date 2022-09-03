
package azamat.db.repository.din;

import azamat.db.model.entity.din.Ait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AitRepository extends JpaRepository<Ait, Long> {
}