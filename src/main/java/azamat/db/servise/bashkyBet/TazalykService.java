package azamat.db.servise.bashkyBet;

import azamat.db.model.Tazalyk;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface TazalykService {
    Tazalyk saveTazalyk(Tazalyk tazalyk);

    Tazalyk update(Tazalyk tazalyk, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Tazalyk> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile name , Long id);
}
