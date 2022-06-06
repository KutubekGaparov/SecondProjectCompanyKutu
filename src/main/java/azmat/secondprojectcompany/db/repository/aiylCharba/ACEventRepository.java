package azmat.secondprojectcompany.db.repository.aiylCharba;

import azmat.secondprojectcompany.model.entity.aiylCharba.ACEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ACEventRepository extends JpaRepository<ACEvent,Long> {

}
