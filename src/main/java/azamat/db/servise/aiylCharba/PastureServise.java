package azamat.db.servise.aiylCharba;

import azamat.db.model.entity.aiylCharba.Pasture;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PastureServise {

    Pasture savePasture(Pasture pasture);

    Pasture update(Pasture pasture, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Pasture> getAll();
}
