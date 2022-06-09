package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.servise.kultura.HousesOfCultureService;
import azmat.secondprojectcompany.model.entity.Kultura.HousesOfCulture;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HousesOfCultureServiceImpl implements HousesOfCultureService {
    @Override
    public HousesOfCulture saveHousesOfCulture(HousesOfCulture houses) {
        return null;
    }

    @Override
    public HousesOfCulture update(HousesOfCulture houses, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
