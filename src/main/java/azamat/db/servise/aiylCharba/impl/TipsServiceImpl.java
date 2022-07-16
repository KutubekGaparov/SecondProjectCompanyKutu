package azamat.db.servise.aiylCharba.impl;

import azamat.db.repository.aiylCharba.TipsRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.aiylCharba.Tips;
import azamat.db.servise.aiylCharba.TipsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TipsServiceImpl implements TipsService {

    private TipsRepository repository;

    @Override
    public Tips saveTips(Tips tips) {
        return repository.save(tips);
    }

    @Override
    @Transactional
    public Tips update(Tips tips, Long id) {
        Tips pasture1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = pasture1.getText();
        String newText = tips.getText();
        if (!oldText.equals(newText)) {
            pasture1.setText(newText);
        }
        return pasture1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
         repository.deleteById(id);
         return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Tips> getAll() {
        return repository.findAll();
    }
}
