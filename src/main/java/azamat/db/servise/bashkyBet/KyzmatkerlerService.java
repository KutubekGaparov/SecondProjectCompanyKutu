package azamat.db.servise.bashkyBet;

import azamat.model.Kyzmatkerler;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KyzmatkerlerService {
    Kyzmatkerler saveKyzmatkerler(Kyzmatkerler kyzmatkerler);

    Kyzmatkerler update(Kyzmatkerler kyzmatkerler, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Kyzmatkerler> getAll();
}
