package azamat.db.servise.bilimBeruu;

import azamat.db.model.entity.bilimBeruu.ORT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface ORTService {
    ORT saveORT(ORT ort);

    ORT update(ORT ort, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<ORT> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
