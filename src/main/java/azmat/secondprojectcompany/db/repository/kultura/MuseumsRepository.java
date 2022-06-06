package azmat.secondprojectcompany.db.repository.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.Museums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumsRepository extends JpaRepository<Museums, Long> {
}