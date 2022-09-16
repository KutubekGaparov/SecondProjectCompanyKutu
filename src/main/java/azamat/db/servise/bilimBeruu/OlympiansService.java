package azamat.db.servise.bilimBeruu;

import azamat.db.model.entity.bilimBeruu.Olympians;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface OlympiansService {
    Olympians saveOlympians(Olympians olympians);

    Olympians update(Olympians olympians, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Olympians> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
