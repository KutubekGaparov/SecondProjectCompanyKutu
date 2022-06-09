package azmat.secondprojectcompany.db.servise.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthInitiatives;
import org.springframework.http.ResponseEntity;

public interface YouthInitiativesService {
    YouthInitiatives saveYouthInitiatives(YouthInitiatives youthInitiatives);

    YouthInitiatives update(YouthInitiatives youthInitiatives, Long id);

    ResponseEntity<?> deleteById(Long id);
}
