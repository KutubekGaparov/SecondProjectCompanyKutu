package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.DEvents;
import org.springframework.http.ResponseEntity;

public interface DEventService {
    DEvents saveDEvents(DEvents dEvents);

    DEvents update(DEvents dEvents, Long id);

    ResponseEntity<?> deleteById(Long id);
}
