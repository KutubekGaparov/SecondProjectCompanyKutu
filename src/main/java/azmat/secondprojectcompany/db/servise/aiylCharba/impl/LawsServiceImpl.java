package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.repository.aiylCharba.LawsRepository;
import azmat.secondprojectcompany.db.servise.aiylCharba.LawsService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.aiylCharba.GrainGrowing;
import azmat.secondprojectcompany.model.entity.aiylCharba.Laws;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class LawsServiceImpl implements LawsService {

    private LawsRepository lawsRepository;

    @Override
    public Laws saveLaws(Laws laws) {
        return lawsRepository.save(laws);
    }

    @Override
    @Transactional
    public Laws update(Laws laws, Long id) {
        Laws laws1 = lawsRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = laws1.getText();
        String newText = laws.getText();
        if (!oldText.equals(newText)) {
            laws1.setText(newText);
        }
        return laws1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        lawsRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Laws> getAll() {
        return lawsRepository.findAll();
    }
}
