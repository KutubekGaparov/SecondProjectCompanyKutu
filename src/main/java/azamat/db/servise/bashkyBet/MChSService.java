package azamat.db.servise.bashkyBet;

import azamat.db.model.MChS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface MChSService {
    MChS saveEvent(MChS mChS);

    MChS update(MChS mChS, Long id);

    ResponseEntity<?> deleteById(Long id);
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
    List<MChS> getAll();
}
