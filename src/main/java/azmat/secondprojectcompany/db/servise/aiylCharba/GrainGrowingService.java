package azmat.secondprojectcompany.db.servise.aiylCharba;

import azmat.secondprojectcompany.model.entity.aiylCharba.AnimalHusbandry;
import azmat.secondprojectcompany.model.entity.aiylCharba.GrainGrowing;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GrainGrowingService {

    GrainGrowing saveGrainGraving(GrainGrowing grainGrowing);

    GrainGrowing update(GrainGrowing grainGrowing, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<GrainGrowing> getAll();

}
