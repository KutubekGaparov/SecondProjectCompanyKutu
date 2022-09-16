package azamat.db.servise.jashtarIshteri;

import azamat.db.model.entity.jashtarIshteri.SportsEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface SportsEventsService {
    SportsEvents saveSportsEvents(SportsEvents sportsEvents);

    SportsEvents update(SportsEvents sportsEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<SportsEvents> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
