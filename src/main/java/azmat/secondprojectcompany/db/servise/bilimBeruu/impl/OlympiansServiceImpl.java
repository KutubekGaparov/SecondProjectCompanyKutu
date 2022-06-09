package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.servise.bilimBeruu.OlympiansService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Olympians;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OlympiansServiceImpl implements OlympiansService {
    @Override
    public Olympians saveOlympians(Olympians olympians) {
        return null;
    }

    @Override
    public Olympians update(Olympians olympians, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
