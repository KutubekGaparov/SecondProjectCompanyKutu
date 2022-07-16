package azamat.db.servise.dinService.dinServiceImpl;

import azamat.db.repository.din.EthicsRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.din.Ethics;
import azamat.db.servise.dinService.EthicsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EthicsServiceImpl implements EthicsService {

    private EthicsRepository repository;

    @Override
    public Ethics saveEthics(Ethics ethics) {
        return repository.save(ethics);
    }

    @Override
    @Transactional
    public Ethics update(Ethics ethics, Long id) {
        Ethics circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = ethics.getText();
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
    public List<Ethics> getAll() {
        return repository.findAll();
    }
}
