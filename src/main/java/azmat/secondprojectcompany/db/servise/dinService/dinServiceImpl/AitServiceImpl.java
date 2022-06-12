package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.repository.din.AitRepository;
import azmat.secondprojectcompany.db.servise.dinService.AitService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Circles;
import azmat.secondprojectcompany.model.entity.din.Ait;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AitServiceImpl implements AitService {

    private AitRepository aitRepository;

    @Override
    public Ait saveAit(Ait ait) {
        return aitRepository.save(ait);
    }

    @Override
    @Transactional
    public Ait update(Ait ait, Long id) {
        Ait circles1 = aitRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = ait.getText();
        if (!oldText.equals(newText)) {
            circles1.setText(newText);
        }
        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        aitRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Ait> getAll() {
        return aitRepository.findAll();
    }
}
