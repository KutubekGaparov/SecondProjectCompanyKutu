package azamat.db.servise.salamattykdySaktoo;

import azamat.db.model.entity.salamattykSaktoo.DoctorsAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface DoctorsAdviceService {
    DoctorsAdvice saveDoctorsAdvice(DoctorsAdvice doctorsAdvice);

    DoctorsAdvice update(DoctorsAdvice doctorsAdvice, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<DoctorsAdvice> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
