package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.servise.kultura.MuseumsService;
import azmat.secondprojectcompany.model.entity.Kultura.Museums;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MuseumsServiceImpl implements MuseumsService {
    @Override
    public Museums saveMuseums(Museums museums) {
        return null;
    }

    @Override
    public Museums update(Museums museums, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
