package azamat.db.servise.jashtarIshteri.Impl;

import azamat.db.repository.jashtarIshteri.EnterprisingYouthRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.jashtarIshteri.EnterprisingYouth;
import azamat.db.servise.jashtarIshteri.EnterprisingYouthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EnterprisingYouthServiceImpl implements EnterprisingYouthService {

    private EnterprisingYouthRepository repository;

    @Override
    public EnterprisingYouth saveEnterprisingYouth(EnterprisingYouth enterprisingYouth) {
        return repository.save(enterprisingYouth);
    }

    @Override
    @Transactional
    public EnterprisingYouth update(EnterprisingYouth enterprisingYouth, Long id) {
        EnterprisingYouth circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getFullName();
        String newText = enterprisingYouth.getFullName();
        if (!oldText.equals(newText)) {
            circles1.setFullName(newText);
        }
        String oldText2 = circles1.getDirection();
        String newText2 = enterprisingYouth.getDirection();
        if (!oldText2.equals(newText2)) {
            circles1.setDirection(newText2);
        }
        String oldText3 = circles1.getResult();
        String newText3 = enterprisingYouth.getResult();
        if (!oldText3.equals(newText3)) {
            circles1.setResult(newText3);
        }
        LocalDate oldText1 = circles1.getAge();
        LocalDate newText1 = enterprisingYouth.getAge();
        if (!oldText1.equals(newText1)) {
            circles1.setAge(newText1);
        }

        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<EnterprisingYouth> getAll() {
        return repository.findAll();
    }
}
