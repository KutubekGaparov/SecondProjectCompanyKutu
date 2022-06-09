package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.Hadj;
import org.springframework.http.ResponseEntity;

public interface HadjService {
    Hadj saveHadj(Hadj hadj);

    Hadj update(Hadj hadj, Long id);

    ResponseEntity<?> deleteById(Long id);
}
