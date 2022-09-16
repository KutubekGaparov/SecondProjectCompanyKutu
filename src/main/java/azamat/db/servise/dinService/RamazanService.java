package azamat.db.servise.dinService;

import azamat.db.model.entity.din.Ramazan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface RamazanService {
    Ramazan saveRamazan(Ramazan ramazan);

    Ramazan update(Ramazan ramazan, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Ramazan> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
