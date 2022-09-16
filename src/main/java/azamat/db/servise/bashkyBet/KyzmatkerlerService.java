package azamat.db.servise.bashkyBet;

import azamat.db.model.Kyzmatkerler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface KyzmatkerlerService {
    Kyzmatkerler saveKyzmatkerler(Kyzmatkerler kyzmatkerler);

    Kyzmatkerler update(Kyzmatkerler kyzmatkerler, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Kyzmatkerler> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
