package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.repository.kultura.HousesOfCultureRepository;
import azmat.secondprojectcompany.db.servise.kultura.HousesOfCultureService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.Kultura.HousesOfCulture;
import azmat.secondprojectcompany.model.entity.aiylCharba.ACEvent;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class HousesOfCultureServiceImpl implements HousesOfCultureService {

    private HousesOfCultureRepository repository;

    @Override
    public HousesOfCulture saveHousesOfCulture(HousesOfCulture houses) {
        return repository.save(houses);
    }

    @Override
    @Transactional
    public HousesOfCulture update(HousesOfCulture houses, Long id) {
        HousesOfCulture acEvent1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = houses.getText();
        String newText = acEvent1.getText();
        if (!oldText.equals(newText)) {
            acEvent1.setText(newText);
        }
        return acEvent1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<HousesOfCulture> getAll() {
        return repository.findAll();
    }
}
