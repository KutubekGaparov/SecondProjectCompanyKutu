package azmat.secondprojectcompany.db.servise.bilimBeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
import org.springframework.http.ResponseEntity;

public interface MOEEventService {

    MOEEvent saveEvent(MOEEvent event);

    MOEEvent update(MOEEvent event, Long id);

    ResponseEntity<?> deleteById(Long id);
}
