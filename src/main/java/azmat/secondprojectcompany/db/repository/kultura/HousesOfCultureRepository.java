package azmat.secondprojectcompany.db.repository.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.HousesOfCulture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesOfCultureRepository extends JpaRepository<HousesOfCulture, Long> {
}