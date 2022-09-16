package azamat.db.servise.salamattykdySaktoo;

import azamat.db.model.entity.salamattykSaktoo.MedicalCenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface MedicalCenterService {
    MedicalCenter saveMedicalCenter(MedicalCenter medicalCenter);

    MedicalCenter update(MedicalCenter medicalCenter, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<MedicalCenter> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
