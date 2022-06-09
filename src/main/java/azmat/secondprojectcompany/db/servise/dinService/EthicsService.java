package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.Ethics;
import org.springframework.http.ResponseEntity;

public interface EthicsService {
    Ethics saveEthics(Ethics ethics);

    Ethics update(Ethics ethics, Long id);

    ResponseEntity<?> deleteById(Long id);

}
