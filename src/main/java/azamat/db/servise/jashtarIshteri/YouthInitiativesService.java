package azamat.db.servise.jashtarIshteri;

import azamat.db.model.entity.jashtarIshteri.YouthInitiatives;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface YouthInitiativesService {
    YouthInitiatives saveYouthInitiatives(YouthInitiatives youthInitiatives);

    YouthInitiatives update(YouthInitiatives youthInitiatives, Long id);

    ResponseEntity<?> deleteById(Long id);


    List<YouthInitiatives> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
