package azamat.db.servise.kultura;

import azamat.model.entity.Kultura.HousesOfCulture;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HousesOfCultureService {
    HousesOfCulture saveHousesOfCulture(HousesOfCulture houses);

    HousesOfCulture update(HousesOfCulture houses, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<HousesOfCulture> getAll();
}
