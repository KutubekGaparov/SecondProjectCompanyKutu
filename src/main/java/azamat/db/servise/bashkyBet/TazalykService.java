package azamat.db.servise.bashkyBet;

import azamat.db.model.Tazalyk;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TazalykService {
    Tazalyk saveTazalyk(Tazalyk tazalyk);

    Tazalyk update(Tazalyk tazalyk, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Tazalyk> getAll();
}
