package azmat.secondprojectcompany.db.servise.aiylCharba;

import azmat.secondprojectcompany.model.entity.aiylCharba.ACEvent;
import azmat.secondprojectcompany.model.entity.aiylCharba.GrainGrowing;
import org.springframework.http.ResponseEntity;

public interface GrainGrowingService {

    GrainGrowing saveGrainGraving(GrainGrowing grainGrowing);

    GrainGrowing update(GrainGrowing grainGrowing, Long id);

    ResponseEntity<?> deleteById(Long id);
}
