package azamat.db.servise.jashtarIshteri;

import azamat.db.model.entity.jashtarIshteri.YouthCommitteeManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface YouthCommitteeManagerService {
    YouthCommitteeManager saveYouthCommitteeManager(YouthCommitteeManager committeeManager);

    YouthCommitteeManager update(YouthCommitteeManager committeeManager, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<YouthCommitteeManager> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
