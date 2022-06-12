package azmat.secondprojectcompany.db.servise.bashkyBet;

import azmat.secondprojectcompany.model.MChS;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MChSService {
    MChS saveEvent(MChS mChS);

    MChS update(MChS mChS, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<MChS> getAll();
}
