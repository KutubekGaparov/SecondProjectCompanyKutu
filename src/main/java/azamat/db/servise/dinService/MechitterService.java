package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Mechitter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface MechitterService {
    Mechitter saveMechitter(Mechitter mechitter);

    Mechitter update(Mechitter mechitter, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Mechitter> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
