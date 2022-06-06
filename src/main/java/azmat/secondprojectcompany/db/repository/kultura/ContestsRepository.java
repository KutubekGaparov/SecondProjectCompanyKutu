package azmat.secondprojectcompany.db.repository.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.Contests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestsRepository extends JpaRepository<Contests, Long> {
}