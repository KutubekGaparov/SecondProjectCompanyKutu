package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Ait;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface AitService {
    Ait saveAit(Ait ait);

    Ait update(Ait ait, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ait> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
