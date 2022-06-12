package azmat.secondprojectcompany.db.servise.jashtarIshteri.Impl;

import azmat.secondprojectcompany.db.repository.jashtarIshteri.SportsEventsRepository;
import azmat.secondprojectcompany.db.servise.jashtarIshteri.SportsEventsService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.SportsEvents;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SportsEventsServiceImpl implements SportsEventsService {

    private SportsEventsRepository repository;

    @Override
    public SportsEvents saveSportsEvents(SportsEvents sportsEvents) {
        return repository.save(sportsEvents);
    }

    @Override
    @Transactional
    public SportsEvents update(SportsEvents sportsEvents, Long id) {
        SportsEvents circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getInfoSportEvents();
        String newText = sportsEvents.getInfoSportEvents();
        if (!oldText.equals(newText)) {
            circles1.setInfoSportEvents(newText);
        }
        return circles1;
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<SportsEvents> getAll() {
        return repository.findAll();
    }
}
