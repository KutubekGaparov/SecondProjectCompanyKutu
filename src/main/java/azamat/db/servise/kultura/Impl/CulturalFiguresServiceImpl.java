package azamat.db.servise.kultura.Impl;

import azamat.db.repository.kultura.CulturalFiguresRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.Kultura.CulturalFigures;
import azamat.db.servise.kultura.CulturalFiguresService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CulturalFiguresServiceImpl implements CulturalFiguresService {

    private CulturalFiguresRepository repository;

    @Override
    public CulturalFigures saveCulturalFigures(CulturalFigures culturalFigures) {
        return repository.save(culturalFigures);
    }

    @Override
    @Transactional
    public CulturalFigures update(CulturalFigures culturalFigures, Long id) {
        CulturalFigures circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = culturalFigures.getText();
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
    public List<CulturalFigures> getAll() {
        return repository.findAll();
    }
}
