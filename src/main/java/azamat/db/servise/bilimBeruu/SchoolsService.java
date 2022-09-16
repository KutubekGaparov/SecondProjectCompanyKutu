package azamat.db.servise.bilimBeruu;

import azamat.db.model.entity.bilimBeruu.Schools;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface SchoolsService {
    Schools saveSchools(Schools schools);

    Schools update(Schools schools, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Schools> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
