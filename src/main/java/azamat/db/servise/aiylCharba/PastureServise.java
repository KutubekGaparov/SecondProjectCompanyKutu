package azamat.db.servise.aiylCharba;

import azamat.db.model.entity.aiylCharba.Pasture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface PastureServise {

    Pasture savePasture(Pasture pasture);

    Pasture update(Pasture pasture, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Pasture> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);
}
