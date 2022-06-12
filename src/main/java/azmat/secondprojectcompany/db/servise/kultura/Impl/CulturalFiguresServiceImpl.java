package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.repository.kultura.CulturalFiguresRepository;
import azmat.secondprojectcompany.db.servise.kultura.CulturalFiguresService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.Kultura.Contests;
import azmat.secondprojectcompany.model.entity.Kultura.CulturalFigures;
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
