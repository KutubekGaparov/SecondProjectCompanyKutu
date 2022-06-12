package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.repository.aiylCharba.PastureRepository;
import azmat.secondprojectcompany.db.servise.aiylCharba.PastureServise;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.aiylCharba.Laws;
import azmat.secondprojectcompany.model.entity.aiylCharba.Pasture;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PastureServiceImpl implements PastureServise {

    private PastureRepository pastureRepository;

    @Override
    public Pasture savePasture(Pasture pasture) {
        return pastureRepository.save(pasture);
    }

    @Override
    @Transactional
    public Pasture update(Pasture pasture, Long id) {
        Pasture pasture1 = pastureRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = pasture1.getText();
        String newText = pasture.getText();
        if (!oldText.equals(newText)) {
            pasture1.setText(newText);
        }
        String oldName = pasture1.getDirectorFullName();
        String newName = pasture.getDirectorFullName();
        if (!oldName.equals(newName)) {
            pasture1.setDirectorFullName(newName);
        }
        return pasture1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Pasture> getAll() {
        return pastureRepository.findAll();
    }
}
