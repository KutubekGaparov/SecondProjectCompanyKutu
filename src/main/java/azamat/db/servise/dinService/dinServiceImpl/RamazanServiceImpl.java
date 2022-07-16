package azamat.db.servise.dinService.dinServiceImpl;

import azamat.db.repository.din.RamazanRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.din.Ramazan;
import azamat.db.servise.dinService.RamazanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RamazanServiceImpl implements RamazanService {

    private RamazanRepository repository;

    @Override
    public Ramazan saveRamazan(Ramazan ramazan) {
        return repository.save(ramazan);
    }

    @Override
    @Transactional
    public Ramazan update(Ramazan ramazan, Long id) {
        Ramazan circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = ramazan.getText();
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
    public List<Ramazan> getAll() {
        return repository.findAll();
    }
}
