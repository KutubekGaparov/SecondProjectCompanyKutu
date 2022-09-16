package azamat.db.servise.kultura;

import azamat.db.model.entity.Kultura.Museums;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface MuseumsService {
    Museums saveMuseums(Museums museums);

    Museums update(Museums museums, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Museums> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
