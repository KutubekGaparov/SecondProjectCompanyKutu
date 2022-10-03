package azamat.db.servise.aiylCharba;

import azamat.db.model.entity.aiylCharba.ACEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface ACEventService {

    ACEvent saveAsEvent(ACEvent acEvent);

    ACEvent update(ACEvent acEvent,Long id);

    ResponseEntity<?> deleteById(Long id);

    List<ACEvent> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
}
