package azmat.secondprojectcompany.db.servise.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthInitiatives;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface YouthInitiativesService {
    YouthInitiatives saveYouthInitiatives(YouthInitiatives youthInitiatives);

    YouthInitiatives update(YouthInitiatives youthInitiatives, Long id);

    ResponseEntity<?> deleteById(Long id);


    List<YouthInitiatives> getAll();
}
