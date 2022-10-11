package azamat.db.servise.bashkyBet;

import azamat.db.model.Ataktuular;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;

public interface AtaktuularService {

    Ataktuular save(Ataktuular ataktuular);

    Ataktuular update(Ataktuular ataktuular, Long id);

    ResponseEntity<?> deleteById(Long id);

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
}
