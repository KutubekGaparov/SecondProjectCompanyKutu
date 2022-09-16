package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Hadj;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface HadjService {
    Hadj saveHadj(Hadj hadj);

    Hadj update(Hadj hadj, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Hadj> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
