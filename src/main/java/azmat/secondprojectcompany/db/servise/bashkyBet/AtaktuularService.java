package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.Ataktuular;
import azmat.secondprojectcompany.model.Kyzmatkerler;
import org.springframework.http.ResponseEntity;

public interface AtaktuularService {

    Ataktuular save(Ataktuular ataktuular);

    Ataktuular update(Ataktuular ataktuular, Long id);

    ResponseEntity<?> deleteById(Long id);
}
