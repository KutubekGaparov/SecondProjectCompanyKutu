package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.RamazanService;
import azmat.secondprojectcompany.model.entity.din.Ramazan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RamazanServiceImpl implements RamazanService {
    @Override
    public Ramazan saveRamazan(Ramazan ramazan) {
        return null;
    }

    @Override
    public Ramazan update(Ramazan ramazan, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
