package azamat.db.servise.aiylCharba;

import azamat.db.model.entity.aiylCharba.Laws;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface LawsService {

    Laws saveLaws(Laws laws);

    Laws update(Laws laws, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Laws> getAll();
}
