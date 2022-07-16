package azamat.db.servise.dinService.dinServiceImpl;

import azamat.db.repository.din.HadjRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.din.Hadj;
import azamat.db.servise.dinService.HadjService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class HadjServiceImpl implements HadjService {

    private HadjRepository repository;

    @Override
    public Hadj saveHadj(Hadj hadj) {
        return repository.save(hadj);
    }

    @Override
    @Transactional
    public Hadj update(Hadj hadj, Long id) {
        Hadj circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = hadj.getText();
        if (!oldText.equals(newText)) {
            circles1.setText(newText);
        }
        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Hadj> getAll() {
        return repository.findAll();
    }
}
