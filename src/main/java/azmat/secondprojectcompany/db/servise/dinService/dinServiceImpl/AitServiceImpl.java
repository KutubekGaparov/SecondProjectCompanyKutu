package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.AitService;
import azmat.secondprojectcompany.model.entity.din.Ait;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AitServiceImpl implements AitService {
    @Override
    public Ait saveAit(Ait ait) {
        return null;
    }

    @Override
    public Ait update(Ait ait, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
