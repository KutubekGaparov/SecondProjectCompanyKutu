package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.Ramazan;
import org.springframework.http.ResponseEntity;

public interface RamazanService {
    Ramazan saveRamazan(Ramazan ramazan);

    Ramazan update(Ramazan ramazan, Long id);

    ResponseEntity<?> deleteById(Long id);
}
