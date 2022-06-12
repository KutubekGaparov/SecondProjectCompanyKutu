package azmat.secondprojectcompany.db.servise.salamattykdySaktoo.impl;

import azmat.secondprojectcompany.db.repository.salamattykSaktoo.DoctorsAdviceRepository;
import azmat.secondprojectcompany.db.servise.salamattykdySaktoo.DoctorsAdviceService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.Kultura.Contests;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.DoctorsAdvice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorsAdviceServiceImpl implements DoctorsAdviceService {

    private DoctorsAdviceRepository repository;

    @Override
    public DoctorsAdvice saveDoctorsAdvice(DoctorsAdvice doctorsAdvice) {
        return repository.save(doctorsAdvice);
    }

    @Override
    @Transactional
    public DoctorsAdvice update(DoctorsAdvice doctorsAdvice, Long id) {
        DoctorsAdvice circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = doctorsAdvice.getText();
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
    public List<DoctorsAdvice> getAll() {
        return repository.findAll();
    }
}
