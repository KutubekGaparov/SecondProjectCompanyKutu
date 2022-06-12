package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.DEvents;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DEventService {
    DEvents saveDEvents(DEvents dEvents);

    DEvents update(DEvents dEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<DEvents> getAll();
}
