package azamat.db.servise.bashkyBet;

import azamat.db.model.Ataktuular;
import azamat.db.model.Kyzmatkerler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface AtaktuularService {

    Ataktuular save(Ataktuular ataktuular);

    Ataktuular update(Ataktuular ataktuular, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ataktuular> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
}
