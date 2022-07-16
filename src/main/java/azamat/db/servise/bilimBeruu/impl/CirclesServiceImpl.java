package azamat.db.servise.bilimBeruu.impl;

import azamat.db.repository.bilimPeruu.CirclesRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.bilimBeruu.Circles;
import azamat.db.servise.bilimBeruu.CirclesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CirclesServiceImpl implements CirclesService {

    private CirclesRepository circlesRepository;

    @Override
    public Circles saveCircles(Circles circles) {
        return circlesRepository.save(circles);
    }

    @Override
    @Transactional
    public Circles update(Circles circles, Long id) {
        Circles circles1 = circlesRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles.getInfo();
        String newText = circles1.getInfo();
        if (!oldText.equals(newText)) {
            circles1.setInfo(newText);
        }
        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        circlesRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Circles> getAll() {
        return circlesRepository.findAll();
    }
}
