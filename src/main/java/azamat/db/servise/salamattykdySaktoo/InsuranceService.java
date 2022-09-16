package azamat.db.servise.salamattykdySaktoo;

import azamat.db.model.entity.salamattykSaktoo.Insurance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface InsuranceService {
    Insurance saveInsurance(Insurance insurance);

    Insurance update(Insurance insurance, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Insurance> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
