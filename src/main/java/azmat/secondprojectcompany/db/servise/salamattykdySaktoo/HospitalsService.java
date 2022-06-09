package azmat.secondprojectcompany.db.servise.salamattykdySaktoo;

import azmat.secondprojectcompany.model.entity.salamattykSaktoo.Hospitals;
import org.springframework.http.ResponseEntity;

public interface HospitalsService {
    Hospitals saveHospitals(Hospitals hospitals);

    Hospitals update(Hospitals hospitals, Long id);

    ResponseEntity<?> deleteById(Long id);

}
