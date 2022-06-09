package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.MechitterService;
import azmat.secondprojectcompany.model.entity.din.Mechitter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MechitterServiceImpl implements MechitterService {
    @Override
    public Mechitter saveMechitter(Mechitter mechitter) {
        return null;
    }

    @Override
    public Mechitter update(Mechitter mechitter, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
