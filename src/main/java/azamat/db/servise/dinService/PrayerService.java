package azamat.db.servise.dinService;

import azamat.model.entity.din.Prayer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrayerService {
    Prayer savePrayer(Prayer prayer);

    Prayer update(Prayer prayer, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Prayer> getAll();
}
