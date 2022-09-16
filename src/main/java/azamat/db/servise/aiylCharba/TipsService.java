package azamat.db.servise.aiylCharba;

import azamat.db.model.entity.aiylCharba.Tips;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface TipsService {

    Tips saveTips(Tips tips);

    Tips update(Tips tips, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Tips> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
}
