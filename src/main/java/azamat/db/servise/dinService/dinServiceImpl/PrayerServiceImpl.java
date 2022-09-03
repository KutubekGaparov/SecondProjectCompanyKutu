package azamat.db.servise.dinService.dinServiceImpl;

import azamat.db.repository.din.PrayerRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.din.Prayer;
import azamat.db.servise.dinService.PrayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PrayerServiceImpl implements PrayerService {

    private PrayerRepository repository;

    @Override
    public Prayer savePrayer(Prayer prayer) {
        return repository.save(prayer);
    }

    @Override
    @Transactional
    public Prayer update(Prayer prayer, Long id) {
        Prayer circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = prayer.getText();
        if (!oldText.equals(newText)) {
            circles1.setText(newText);
        }
        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Prayer> getAll() {
        return repository.findAll();
    }
}
