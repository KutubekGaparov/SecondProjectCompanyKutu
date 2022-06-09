package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.DEventService;
import azmat.secondprojectcompany.model.entity.din.DEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DEventServiceImpl implements DEventService {
    @Override
    public DEvents saveDEvents(DEvents dEvents) {
        return null;
    }

    @Override
    public DEvents update(DEvents dEvents, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
