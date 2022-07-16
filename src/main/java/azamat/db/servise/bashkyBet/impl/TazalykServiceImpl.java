package azamat.db.servise.bashkyBet.impl;

import azamat.model.Tazalyk;
import azamat.db.repository.bashkyBet.TazalykRepository;
import azamat.db.servise.bashkyBet.TazalykService;
import azamat.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TazalykServiceImpl implements TazalykService {

    private TazalykRepository tazalykRepository;

    @Override
    public Tazalyk saveTazalyk(Tazalyk tazalyk) {
        return tazalykRepository.save(tazalyk);
    }

    @Override
    @Transactional
    public Tazalyk update(Tazalyk tazalyk, Long id) {
        Tazalyk tazalyk1 = tazalykRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = tazalyk.getFullName();
        String newText = tazalyk1.getFullName();
        if (!oldText.equals(newText)) {
            tazalyk1.setFullName(newText);
        }
        String oldEmail = tazalyk.getEmail();
        String newEmail = tazalyk1.getEmail();
        if (!oldEmail.equals(newEmail)) {
            tazalyk1.setEmail(newEmail);
        }
        String oldPhone = tazalyk.getPhoneNumber();
        String newPhone = tazalyk1.getPhoneNumber();
        if (!Objects.equals(oldPhone, newPhone)) {
            tazalyk1.setPhoneNumber(newPhone);
        }
        LocalDate oldBirthDay = tazalyk.getBirthday();
        LocalDate newBirthDay = tazalyk1.getBirthday();
        if (!oldBirthDay.equals(newBirthDay)) {
            tazalyk1.setBirthday(newBirthDay);
        }


        return tazalyk1;
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        tazalykRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Tazalyk> getAll() {
        return tazalykRepository.findAll();
    }
}

