package azamat.db.repository.aiylCharba;

import azamat.db.model.entity.aiylCharba.ACEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ACEventRepository extends JpaRepository<ACEvent,Long> {

    @Query("select b from Pasture b where b.sss > 1000")
    ACEvent ads();

}
