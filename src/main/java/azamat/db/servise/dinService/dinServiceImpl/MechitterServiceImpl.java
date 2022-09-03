package azamat.db.servise.dinService.dinServiceImpl;

import azamat.db.repository.din.MechitterRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.din.Mechitter;
import azamat.db.servise.dinService.MechitterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MechitterServiceImpl implements MechitterService {

    private MechitterRepository repository;

    @Override
    public Mechitter saveMechitter(Mechitter mechitter) {
        return repository.save(mechitter);
    }

    @Override
    @Transactional
    public Mechitter update(Mechitter mechitter, Long id) {
        Mechitter circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getAddress();
        String newText = mechitter.getAddress();
        if (!oldText.equals(newText)) {
            circles1.setAddress(newText);
        }
        String oldName = circles1.getImamName();
        String newName = mechitter.getImamName();
        if (!oldName.equals(newName)) {
            mechitter.setImamName(newName);
        }
        String oldName2 = circles1.getImamLastName();
        String newName2 = mechitter.getImamLastName();
        if (!oldName2.equals(newName2)) {
            mechitter.setImamLastName(newName2);
        }
        String oldName1 = circles1.getMosqueName();
        String newName1 = mechitter.getMosqueName();
        if (!oldName1.equals(newName1)) {
            mechitter.setMosqueName(newName1);
        }
        String oldName3 = circles1.getEmail();
        String newName3 = mechitter.getEmail();
        if (!oldName3.equals(newName3)) {
            mechitter.setEmail(newName3);
        }
        LocalDate oldName4 = circles1.getBirthDay();
        LocalDate newName4 = mechitter.getBirthDay();
        if (!oldName4.equals(newName4)) {
            mechitter.setBirthDay(newName4);
        }
        String oldName5 = circles1.getPositions();
        String newName5 = mechitter.getPositions();
        if (!oldName5.equals(newName5)) {
            mechitter.setPositions(newName5);
        }
        String oldName6 = circles1.getPhone();
        String newName6 = mechitter.getPhone();
        if (!oldName6.equals(newName6)) {
            mechitter.setPhone(newName6);
        }
        return circles1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Mechitter> getAll() {
        return repository.findAll();
    }
}
