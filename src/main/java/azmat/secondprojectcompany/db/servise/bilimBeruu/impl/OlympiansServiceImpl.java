package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.repository.bilimPeruu.OlympiansRepository;
import azmat.secondprojectcompany.db.servise.bilimBeruu.OlympiansService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Olympians;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OlympiansServiceImpl implements OlympiansService {

    private OlympiansRepository olympiansRepository;

    @Override
    public Olympians saveOlympians(Olympians olympians) {
        return olympiansRepository.save(olympians);
    }

    @Override
    @Transactional
    public Olympians update(Olympians olympians, Long id) {
        Olympians moeEvent = olympiansRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = moeEvent.getText();
        String newText = olympians.getText();
        if (!oldText.equals(newText)) {
            moeEvent.setText(newText);
        }
        return moeEvent;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        olympiansRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Olympians> getAll() {
        return olympiansRepository.findAll();
    }
}
