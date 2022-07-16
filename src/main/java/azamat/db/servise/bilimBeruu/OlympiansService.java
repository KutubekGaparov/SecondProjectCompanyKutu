package azamat.db.servise.bilimBeruu;

import azamat.model.entity.bilimBeruu.Olympians;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OlympiansService {
    Olympians saveOlympians(Olympians olympians);

    Olympians update(Olympians olympians, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Olympians> getAll();
}
