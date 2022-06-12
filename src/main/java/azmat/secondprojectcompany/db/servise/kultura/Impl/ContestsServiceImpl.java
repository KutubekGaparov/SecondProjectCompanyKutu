package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.repository.kultura.ContestsRepository;
import azmat.secondprojectcompany.db.servise.kultura.ContestsService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.Kultura.Contests;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthCommitteeManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ContestsServiceImpl implements ContestsService {

    private ContestsRepository repository;

    @Override
    public Contests saveContests(Contests contests) {
        return repository.save(contests);
    }

    @Override
    @Transactional
    public Contests update(Contests contests, Long id) {
        Contests circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getText();
        String newText = contests.getText();
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
    public List<Contests> getAll() {
        return repository.findAll();
    }
}
