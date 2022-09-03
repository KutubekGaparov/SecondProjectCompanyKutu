
package azamat.db.repository.bilimPeruu;

import azamat.db.model.entity.bilimBeruu.Kindergartens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindergartensRepository extends JpaRepository<Kindergartens, Long> {
}