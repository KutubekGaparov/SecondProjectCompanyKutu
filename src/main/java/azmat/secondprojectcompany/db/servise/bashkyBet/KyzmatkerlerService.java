package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.Kyzmatkerler;
import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
import org.springframework.http.ResponseEntity;

public interface KyzmatkerlerService {
    Kyzmatkerler saveKyzmatkerler(Kyzmatkerler kyzmatkerler);

    Kyzmatkerler update(Kyzmatkerler kyzmatkerler, Long id);

    ResponseEntity<?> deleteById(Long id);
}
