package azamat.db.servise.dinService;

import azamat.model.entity.din.Ethics;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EthicsService {
    Ethics saveEthics(Ethics ethics);

    Ethics update(Ethics ethics, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ethics> getAll();
}
