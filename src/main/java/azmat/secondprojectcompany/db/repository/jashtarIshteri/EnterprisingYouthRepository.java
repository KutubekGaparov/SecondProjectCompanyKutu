package azmat.secondprojectcompany.db.repository.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.jashtarIshteri.EnterprisingYouth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterprisingYouthRepository extends JpaRepository<EnterprisingYouth, Long> {
}