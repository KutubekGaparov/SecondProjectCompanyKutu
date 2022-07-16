package azamat.db.servise.dinService;

import azamat.model.entity.din.DEvents;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DEventService {
    DEvents saveDEvents(DEvents dEvents);

    DEvents update(DEvents dEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<DEvents> getAll();
}
