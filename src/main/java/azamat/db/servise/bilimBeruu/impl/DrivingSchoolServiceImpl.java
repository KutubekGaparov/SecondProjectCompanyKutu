package azamat.db.servise.bilimBeruu.impl;

import azamat.db.repository.bilimPeruu.DrivingSchoolRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.bilimBeruu.DrivingSchool;
import azamat.db.servise.bilimBeruu.DrivingSchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DrivingSchoolServiceImpl implements DrivingSchoolService {

    private DrivingSchoolRepository drivingSchoolRepository;

    @Override
    public DrivingSchool saveDrivingSchool(DrivingSchool drivingSchool) {
        return null;
    }

    @Override
    @Transactional
    public DrivingSchool update(DrivingSchool drivingSchool, Long id) {
        DrivingSchool drivingSchool1 = drivingSchoolRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = drivingSchool.getDirector();
        String newText = drivingSchool1.getDirector();
        if (!oldText.equals(newText)) {
            drivingSchool1.setDirector(newText);
        }
          String oldText2 = drivingSchool.getPhoneNumber();
        String newText2 = drivingSchool1.getPhoneNumber();
        if (!oldText2.equals(newText2)) {
            drivingSchool1.setPhoneNumber(newText2);
        }
          String oldText1 = drivingSchool.getDrivingCourseName();
        String newText1 = drivingSchool1.getDrivingCourseName();
        if (!oldText1.equals(newText1)) {
            drivingSchool1.setDrivingCourseName(newText1);
        }

        return drivingSchool1;
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        drivingSchoolRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<DrivingSchool> getAll() {
        return drivingSchoolRepository.findAll();
    }
}
