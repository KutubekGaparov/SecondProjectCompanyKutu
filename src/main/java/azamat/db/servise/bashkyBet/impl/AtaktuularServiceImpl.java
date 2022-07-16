package azamat.db.servise.bashkyBet.impl;

import azamat.db.repository.bashkyBet.AtaktuularRepository;
import azamat.db.servise.bashkyBet.AtaktuularService;
import azamat.exceptions.BadRequestException;
import azamat.model.Ataktuular;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AtaktuularServiceImpl implements AtaktuularService {

    private AtaktuularRepository repository;

    @Override
    public Ataktuular save(Ataktuular ataktuular) {
        return repository.save(ataktuular);
    }

    @Override
    @Transactional
    public Ataktuular update(Ataktuular ataktuular, Long id) {
        Ataktuular ataktuular1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = ataktuular.getInfo();
        String newText = ataktuular1.getInfo();
        if (!oldText.equals(newText)) {
            ataktuular1.setInfo(newText);
        }
        return ataktuular1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
