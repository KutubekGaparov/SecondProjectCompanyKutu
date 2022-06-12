package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.Tazalyk;
import azmat.secondprojectcompany.model.entity.aiylCharba.ACEvent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TazalykService {
    Tazalyk saveTazalyk(Tazalyk tazalyk);

    Tazalyk update(Tazalyk tazalyk, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Tazalyk> getAll();
}
