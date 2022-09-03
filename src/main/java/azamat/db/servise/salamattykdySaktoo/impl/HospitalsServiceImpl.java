package azamat.db.servise.salamattykdySaktoo.impl;

import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.salamattykSaktoo.Hospitals;
import azamat.db.repository.salamattykSaktoo.HospitalsRepository;
import azamat.db.servise.salamattykdySaktoo.HospitalsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalsServiceImpl implements HospitalsService {

    private HospitalsRepository repository;

    @Override
    public Hospitals saveHospitals(Hospitals hospitals) {
        return repository.save(hospitals);
    }

    @Override
    @Transactional
    public Hospitals update(Hospitals hospitals, Long id) {
        Hospitals circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getAddress();
        String newText = hospitals.getAddress();
        if (!oldText.equals(newText)) {
            circles1.setAddress(newText);
        }
        String oldText1 = circles1.getDirectorHospital();
        String newText1 = hospitals.getDirectorHospital();
        if (!oldText1.equals(newText1)) {
            circles1.setDirectorHospital(newText1);
        }
        String oldText2 = circles1.getEmail();
        String newText2 = hospitals.getEmail();
        if (!oldText2.equals(newText2)) {
            circles1.setEmail(newText2);
        }
        String oldText3 = circles1.getHospitalName();
        String newText3 = hospitals.getHospitalName();
        if (!oldText3.equals(newText3)) {
            circles1.setHospitalName(newText3);
        }
        String oldText4 = circles1.getPhoneNumber();
        String newText4 = hospitals.getPhoneNumber();
        if (!oldText4.equals(newText4)) {
            circles1.setPhoneNumber(newText4);
        }

        return circles1;
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Hospitals> getAll() {
        return repository.findAll();
    }
}
