package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.servise.aiylCharba.AnimalHusbandryService;
import azmat.secondprojectcompany.model.entity.aiylCharba.AnimalHusbandry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AnimalHusbandryServiceImpl implements AnimalHusbandryService {
    @Override
    public AnimalHusbandry saveAsEvent(AnimalHusbandry animalHusbandry) {
        return null;
    }

    @Override
    public AnimalHusbandry update(AnimalHusbandry animalHusbandry, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
