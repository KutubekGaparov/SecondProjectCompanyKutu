package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.MChS;
import org.springframework.http.ResponseEntity;

public interface MChSService {
    MChS saveEvent(MChS mChS);

    MChS update(MChS mChS, Long id);

    ResponseEntity<?> deleteById(Long id);
}
