package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Ramazan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RamazanService {
    Ramazan saveRamazan(Ramazan ramazan);

    Ramazan update(Ramazan ramazan, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ramazan> getAll();
}
