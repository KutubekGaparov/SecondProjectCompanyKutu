package azmat.secondprojectcompany.db.servise.dinService;

import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReligionSchoolService {
    ReligionSchool saveReligionSchool(ReligionSchool religionSchool);

    ReligionSchool update(ReligionSchool religionSchool, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<ReligionSchool> getAll();
}
