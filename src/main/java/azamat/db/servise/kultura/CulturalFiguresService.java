package azamat.db.servise.kultura;

import azamat.db.model.entity.Kultura.CulturalFigures;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface CulturalFiguresService {
    CulturalFigures saveCulturalFigures(CulturalFigures culturalFigures);

    CulturalFigures update(CulturalFigures culturalFigures, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<CulturalFigures> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
