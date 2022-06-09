package azmat.secondprojectcompany.db.servise.salamattykdySaktoo;

import azmat.secondprojectcompany.model.entity.salamattykSaktoo.MedicalCenter;
import org.springframework.http.ResponseEntity;

public interface MedicalCenterService {
    MedicalCenter saveMedicalCenter(MedicalCenter medicalCenter);

    MedicalCenter update(MedicalCenter medicalCenter, Long id);

    ResponseEntity<?> deleteById(Long id);
}
