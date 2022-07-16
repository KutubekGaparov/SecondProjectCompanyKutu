package azamat.db.servise.kultura;

import azamat.model.entity.Kultura.CulturalFigures;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CulturalFiguresService {
    CulturalFigures saveCulturalFigures(CulturalFigures culturalFigures);

    CulturalFigures update(CulturalFigures culturalFigures, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<CulturalFigures> getAll();
}
