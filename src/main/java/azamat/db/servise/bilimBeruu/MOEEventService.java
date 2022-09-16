package azamat.db.servise.bilimBeruu;

import azamat.db.model.entity.bilimBeruu.MOEEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface MOEEventService {

    MOEEvent saveEvent(MOEEvent event);

    MOEEvent update(MOEEvent event, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<MOEEvent> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
