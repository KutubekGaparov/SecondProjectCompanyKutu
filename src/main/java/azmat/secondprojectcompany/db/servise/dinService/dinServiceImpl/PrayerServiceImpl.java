package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.PrayerService;
import azmat.secondprojectcompany.model.entity.din.Prayer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PrayerServiceImpl implements PrayerService {
    @Override
    public Prayer savePrayer(Prayer prayer) {
        return null;
    }

    @Override
    public Prayer update(Prayer prayer, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
