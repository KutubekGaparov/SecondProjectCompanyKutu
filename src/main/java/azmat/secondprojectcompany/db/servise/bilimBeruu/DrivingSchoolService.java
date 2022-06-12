package azmat.secondprojectcompany.db.servise.bilimBeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.DrivingSchool;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DrivingSchoolService {
    DrivingSchool saveDrivingSchool(DrivingSchool drivingSchool);

    DrivingSchool update(DrivingSchool drivingSchool, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<DrivingSchool> getAll();
}
