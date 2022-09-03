package azamat.db.repository.din;

import azamat.db.model.entity.din.Ethics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EthicsRepository extends JpaRepository<Ethics, Long> {
}