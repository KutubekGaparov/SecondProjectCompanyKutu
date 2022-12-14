package azamat.db.servise.kultura;

import azamat.db.model.entity.Kultura.CultureEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface CultureEventsService {
    CultureEvents saveCultureEvents(CultureEvents cultureEvents);

    CultureEvents update(CultureEvents cultureEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<CultureEvents> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
