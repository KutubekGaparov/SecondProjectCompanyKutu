package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.servise.bilimBeruu.DrivingSchoolService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.DrivingSchool;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DrivingSchoolServiceImpl implements DrivingSchoolService {
    @Override
    public DrivingSchool saveDrivingSchool(DrivingSchool drivingSchool) {
        return null;
    }

    @Override
    public DrivingSchool update(DrivingSchool drivingSchool, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
