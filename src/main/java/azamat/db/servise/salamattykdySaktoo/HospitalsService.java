package azamat.db.servise.salamattykdySaktoo;

import azamat.db.model.entity.salamattykSaktoo.Hospitals;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface HospitalsService {
    Hospitals saveHospitals(Hospitals hospitals);

    Hospitals update(Hospitals hospitals, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Hospitals> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
}
