package azmat.secondprojectcompany.db.servise.bilimBeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.ORT;
import org.springframework.http.ResponseEntity;

public interface ORTService {
    ORT saveORT(ORT ort);

    ORT update(ORT ort, Long id);

    ResponseEntity<?> deleteById(Long id);
}
