package azmat.secondprojectcompany.db.servise.bashkyBet.impl;

import azmat.secondprojectcompany.db.repository.bashkyBet.KyzmatkerlerRepository;
import azmat.secondprojectcompany.db.servise.bashkyBet.KyzmatkerlerService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.Ataktuular;
import azmat.secondprojectcompany.model.Kyzmatkerler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class KyzmatkerlerServiceImpl implements KyzmatkerlerService {

    private KyzmatkerlerRepository kyzmatkerlerRepository;

    @Override
    public Kyzmatkerler saveKyzmatkerler(Kyzmatkerler kyzmatkerler) {
        return kyzmatkerlerRepository.save(kyzmatkerler);
    }

    @Override
    @Transactional
    public Kyzmatkerler update(Kyzmatkerler kyzmatkerler, Long id) {
        Kyzmatkerler kyzmatkerler1 = kyzmatkerlerRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = kyzmatkerler.getFirstName();
        String newText = kyzmatkerler1.getFirstName();
        if (!oldText.equals(newText)) {
            kyzmatkerler1.setFirstName(newText);
        }
        String oldName = kyzmatkerler.getLastName();
        String newName = kyzmatkerler1.getLastName();
        if (!oldName.equals(newName)) {
            kyzmatkerler1.setLastName(newName);
        }
        String oldPatronymic = kyzmatkerler.getPatronymic();
        String newPatronymic = kyzmatkerler1.getPatronymic();
        if (!oldPatronymic.equals(newPatronymic)) {
            kyzmatkerler1.setPatronymic(newPatronymic);
        }
        LocalDate oldBirthDay = kyzmatkerler.getBirthDay();
        LocalDate newBirthDay = kyzmatkerler1.getBirthDay();
        if (!oldBirthDay.equals(newBirthDay)) {
            kyzmatkerler1.setBirthDay(newBirthDay);
        }
        String oldPositions = kyzmatkerler.getPositions();
        String newPositions = kyzmatkerler1.getPositions();
        if (!oldPositions.equals(newPositions)) {
            kyzmatkerler1.setPatronymic(newPositions);
        }
        String oldEmail = kyzmatkerler.getEmail();
        String newEmail = kyzmatkerler1.getEmail();
        if (!oldEmail.equals(newEmail)) {
            kyzmatkerler1.setEmail(newEmail);
        }
        String oldPhone = kyzmatkerler.getPhoneNumber();
        String newPhone = kyzmatkerler1.getPhoneNumber();
        if (!Objects.equals(oldPhone, newPhone)) {
            kyzmatkerler1.setPhoneNumber(newPhone);
        }

        return kyzmatkerler1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        kyzmatkerlerRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Kyzmatkerler> getAll() {
        return kyzmatkerlerRepository.findAll();
    }
}
