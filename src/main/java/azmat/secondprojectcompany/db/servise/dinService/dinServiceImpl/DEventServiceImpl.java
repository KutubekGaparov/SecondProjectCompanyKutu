package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.repository.din.DEventsRepository;
import azmat.secondprojectcompany.db.servise.dinService.DEventService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.din.Ait;
import azmat.secondprojectcompany.model.entity.din.DEvents;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DEventServiceImpl implements DEventService {

    private DEventsRepository dEventsRepository;

    @Override
    public DEvents saveDEvents(DEvents dEvents) {
        return dEventsRepository.save(dEvents);
    }

    @Override
    @Transactional
    public DEvents update(DEvents dEvents, Long id) {
        DEvents circles1 = dEventsRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getInfo();
        String newText = dEvents.getInfo();
        if (!oldText.equals(newText)) {
            circles1.setInfo(newText);
        }
        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        dEventsRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<DEvents> getAll() {
        return dEventsRepository.findAll();
    }
}