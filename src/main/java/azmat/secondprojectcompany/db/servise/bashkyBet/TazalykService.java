package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.Tazalyk;
import org.springframework.http.ResponseEntity;

public interface TazalykService {
    Tazalyk saveTazalyk(Tazalyk tazalyk);

    Tazalyk update(Tazalyk tazalyk, Long id);

    ResponseEntity<?> deleteById(Long id);
}
