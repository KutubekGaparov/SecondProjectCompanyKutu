package azmat.secondprojectcompany.db.servise.jashtarIshteri.Impl;

import azmat.secondprojectcompany.db.servise.jashtarIshteri.SportsEventsService;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.SportsEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SportsEventsServiceImpl implements SportsEventsService {
    @Override
    public SportsEvents saveSportsEvents(SportsEvents sportsEvents) {
        return null;
    }

    @Override
    public SportsEvents update(SportsEvents sportsEvents, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
