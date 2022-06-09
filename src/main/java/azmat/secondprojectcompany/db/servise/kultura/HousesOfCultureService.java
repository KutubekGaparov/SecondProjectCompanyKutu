package azmat.secondprojectcompany.db.servise.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.HousesOfCulture;
import org.springframework.http.ResponseEntity;

public interface HousesOfCultureService {
    HousesOfCulture saveHousesOfCulture(HousesOfCulture houses);

    HousesOfCulture update(HousesOfCulture houses, Long id);

    ResponseEntity<?> deleteById(Long id);
}
