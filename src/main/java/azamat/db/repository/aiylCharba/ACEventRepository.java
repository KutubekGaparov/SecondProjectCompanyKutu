package azamat.db.repository.aiylCharba;

import azamat.db.model.entity.aiylCharba.ACEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ACEventRepository extends JpaRepository<ACEvent,Long> {

}
