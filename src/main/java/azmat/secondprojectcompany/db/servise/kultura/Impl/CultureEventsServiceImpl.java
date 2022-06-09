package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.servise.kultura.CultureEventsService;
import azmat.secondprojectcompany.model.entity.Kultura.CultureEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CultureEventsServiceImpl implements CultureEventsService {
    @Override
    public CultureEvents saveCultureEvents(CultureEvents cultureEvents) {
        return null;
    }

    @Override
    public CultureEvents update(CultureEvents cultureEvents, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
