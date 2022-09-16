package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Prayer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface PrayerService {
    Prayer savePrayer(Prayer prayer);

    Prayer update(Prayer prayer, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Prayer> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
