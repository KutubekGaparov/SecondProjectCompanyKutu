package azamat.db.repository.kultura;

import azamat.db.model.entity.Kultura.HousesOfCulture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesOfCultureRepository extends JpaRepository<HousesOfCulture, Long> {
}