package azamat.db.servise.dinService;

import azamat.db.model.entity.din.DEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface DEventService {
    DEvents saveDEvents(DEvents dEvents);

    DEvents update(DEvents dEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<DEvents> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
