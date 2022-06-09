package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.Ait;
import org.springframework.http.ResponseEntity;

public interface AitService {
    Ait saveAit(Ait ait);

    Ait update(Ait ait, Long id);

    ResponseEntity<?> deleteById(Long id);
}
