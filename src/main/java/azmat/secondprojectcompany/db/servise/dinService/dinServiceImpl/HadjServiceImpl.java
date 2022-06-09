package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.HadjService;
import azmat.secondprojectcompany.model.entity.din.Hadj;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HadjServiceImpl implements HadjService {
    @Override
    public Hadj saveHadj(Hadj hadj) {
        return null;
    }

    @Override
    public Hadj update(Hadj hadj, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
