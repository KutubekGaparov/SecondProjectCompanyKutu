package azamat.db.repository.kultura;

import azamat.db.model.entity.Kultura.CulturalFigures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturalFiguresRepository extends JpaRepository<CulturalFigures, Long> {
}