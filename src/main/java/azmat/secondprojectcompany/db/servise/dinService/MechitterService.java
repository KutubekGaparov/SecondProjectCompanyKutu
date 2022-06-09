package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.Mechitter;
import org.springframework.http.ResponseEntity;

public interface MechitterService {
    Mechitter saveMechitter(Mechitter mechitter);

    Mechitter update(Mechitter mechitter, Long id);

    ResponseEntity<?> deleteById(Long id);
}
