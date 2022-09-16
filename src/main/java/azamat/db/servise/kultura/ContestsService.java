package azamat.db.servise.kultura;

import azamat.db.model.entity.Kultura.Contests;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface ContestsService {
    Contests saveContests(Contests contests);

    Contests update(Contests contests, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Contests> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
