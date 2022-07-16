package azamat.db.repository.bilimPeruu;

import azamat.model.entity.bilimBeruu.Circles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirclesRepository extends JpaRepository<Circles, Long> {
}