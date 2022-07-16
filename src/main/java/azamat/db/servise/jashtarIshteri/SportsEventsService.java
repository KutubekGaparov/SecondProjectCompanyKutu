package azamat.db.servise.jashtarIshteri;

import azamat.model.entity.jashtarIshteri.SportsEvents;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SportsEventsService {
    SportsEvents saveSportsEvents(SportsEvents sportsEvents);

    SportsEvents update(SportsEvents sportsEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<SportsEvents> getAll();
}
