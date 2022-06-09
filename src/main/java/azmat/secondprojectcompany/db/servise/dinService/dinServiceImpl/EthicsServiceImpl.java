package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.EthicsService;
import azmat.secondprojectcompany.model.entity.din.Ethics;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EthicsServiceImpl implements EthicsService {
    @Override
    public Ethics saveEthics(Ethics ethics) {
        return null;
    }

    @Override
    public Ethics update(Ethics ethics, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
