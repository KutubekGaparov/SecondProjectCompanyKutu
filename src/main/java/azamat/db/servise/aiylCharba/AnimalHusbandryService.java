package azamat.db.servise.aiylCharba;

import azamat.db.model.entity.aiylCharba.AnimalHusbandry;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnimalHusbandryService {

    AnimalHusbandry saveAsEvent(AnimalHusbandry animalHusbandry);

    AnimalHusbandry update(AnimalHusbandry animalHusbandry, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<AnimalHusbandry> getAll();

}
