package azmat.secondprojectcompany.db.servise.bilimBeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.Circles;
import org.springframework.http.ResponseEntity;

public interface CirclesService {
    Circles saveCircles(Circles circles);

    Circles update(Circles circles, Long id);

    ResponseEntity<?> deleteById(Long id);
}
