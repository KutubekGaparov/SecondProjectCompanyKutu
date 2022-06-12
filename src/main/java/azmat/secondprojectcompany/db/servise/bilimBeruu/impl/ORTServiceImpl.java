package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.repository.bilimPeruu.ORTRepository;
import azmat.secondprojectcompany.db.servise.bilimBeruu.ORTService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
import azmat.secondprojectcompany.model.entity.bilimBeruu.ORT;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ORTServiceImpl implements ORTService {

    private ORTRepository repository;

    @Override
    public ORT saveORT(ORT ort) {
        return repository.save(ort);
    }

    @Override
    @Transactional
    public ORT update(ORT ort, Long id) {
        ORT moeEvent = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = moeEvent.getText();
        String newText = ort.getText();
        if (!oldText.equals(newText)) {
            moeEvent.setText(newText);
        }
        return moeEvent;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<ORT> getAll() {
        return repository.findAll();
    }
}
