package azamat.db.servise.kultura;

import azamat.db.model.entity.Kultura.HousesOfCulture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface HousesOfCultureService {
    HousesOfCulture saveHousesOfCulture(HousesOfCulture houses);

    HousesOfCulture update(HousesOfCulture houses, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<HousesOfCulture> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
