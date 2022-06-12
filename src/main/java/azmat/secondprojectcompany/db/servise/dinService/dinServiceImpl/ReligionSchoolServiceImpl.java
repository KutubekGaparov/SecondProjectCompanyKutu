package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.repository.din.ReligionSchoolRepository;
import azmat.secondprojectcompany.db.servise.dinService.ReligionSchoolService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.din.Ramazan;
import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReligionSchoolServiceImpl implements ReligionSchoolService {

    private ReligionSchoolRepository repository;

    @Override
    public ReligionSchool saveReligionSchool(ReligionSchool religionSchool) {
        return repository.save(religionSchool);
    }

    @Override
    @Transactional
    public ReligionSchool update(ReligionSchool religionSchool, Long id) {
        ReligionSchool circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getAddress();
        String newText = religionSchool.getAddress();
        if (!oldText.equals(newText)) {
            circles1.setAddress(newText);
        }
        String oldName = circles1.getSchoolName();
        String newName = religionSchool.getSchoolName();
        if (!oldName.equals(newName)) {
            circles1.setSchoolName(newName);
        }
        String oldName2 = circles1.getDirector();
        String newName2 = religionSchool.getDirector();
        if (!oldName2.equals(newName2)) {
            circles1.setDirector(newName2);
        }
        LocalDate oldName1 = circles1.getDirectorBirthDay();
        LocalDate newName1 = religionSchool.getDirectorBirthDay();
        if (!oldName1.equals(newName1)) {
            circles1.setDirectorBirthDay(newName1);
        }
        String oldName3 = circles1.getEmail();
        String newName3 = religionSchool.getEmail();
        if (!oldName3.equals(newName3)) {
            circles1.setEmail(newName3);
        }


        String oldName6 = circles1.getPhone();
        String newName6 = religionSchool.getPhone();
        if (!oldName6.equals(newName6)) {
            circles1.setPhone(newName6);
        }
        return circles1;
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<ReligionSchool> getAll() {
        return repository.findAll();
    }
}
