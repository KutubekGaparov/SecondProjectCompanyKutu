package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Ethics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface EthicsService {
    Ethics saveEthics(Ethics ethics);

    Ethics update(Ethics ethics, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ethics> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
