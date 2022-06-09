package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.servise.bilimBeruu.MOEEventService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MOEEventServiceImpl implements MOEEventService {
    @Override
    public MOEEvent saveEvent(MOEEvent event) {
        return null;
    }

    @Override
    public MOEEvent update(MOEEvent event, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
