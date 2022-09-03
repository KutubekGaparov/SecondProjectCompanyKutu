package azamat.db.servise.kultura.Impl;

import azamat.db.repository.kultura.CultureEventsRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.Kultura.CultureEvents;
import azamat.db.servise.kultura.CultureEventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CultureEventsServiceImpl implements CultureEventsService {

    private CultureEventsRepository repository;

    @Override
    public CultureEvents saveCultureEvents(CultureEvents cultureEvents) {
        return repository.save(cultureEvents);
    }

    @Override
    @Transactional
    public CultureEvents update(CultureEvents cultureEvents, Long id) {
        CultureEvents circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = cultureEvents.getText();
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
    public List<CultureEvents> getAll() {
        return repository.findAll();
    }
}
