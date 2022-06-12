package azmat.secondprojectcompany.db.servise.jashtarIshteri.Impl;

import azmat.secondprojectcompany.db.repository.jashtarIshteri.YouthInitiativesRepository;
import azmat.secondprojectcompany.db.servise.jashtarIshteri.YouthInitiativesService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.din.Ait;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthInitiatives;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class YouthInitiativesServiceImpl implements YouthInitiativesService {

    private YouthInitiativesRepository repository;

    @Override
    public YouthInitiatives saveYouthInitiatives(YouthInitiatives youthInitiatives) {
        return repository.save(youthInitiatives);
    }

    @Override
    @Transactional
    public YouthInitiatives update(YouthInitiatives youthInitiatives, Long id) {
        YouthInitiatives circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getInitiatives();
        String newText = youthInitiatives.getInitiatives();
        if (!oldText.equals(newText)) {
            circles1.setInitiatives(newText);
        }
        return circles1;
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<YouthInitiatives> getAll() {
        return repository.findAll();
    }
}
