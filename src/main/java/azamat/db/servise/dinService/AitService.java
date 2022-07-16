package azamat.db.servise.dinService;

import azamat.model.entity.din.Ait;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AitService {
    Ait saveAit(Ait ait);

    Ait update(Ait ait, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ait> getAll();
}
