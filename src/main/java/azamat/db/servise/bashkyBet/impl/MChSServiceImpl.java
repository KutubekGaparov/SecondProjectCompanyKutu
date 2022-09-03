package azamat.db.servise.bashkyBet.impl;

import azamat.db.repository.bashkyBet.MChSRepository;
import azamat.db.servise.bashkyBet.MChSService;
import azamat.exceptions.BadRequestException;
import azamat.db.model.MChS;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MChSServiceImpl implements MChSService {

    private MChSRepository mChSRepository;

    @Override
    public MChS saveEvent(MChS mChS) {
        return mChSRepository.save(mChS);
    }

    @Override
    @Transactional
    public MChS update(MChS mChS, Long id) {
        MChS mChS1 = mChSRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = mChS1.getFullName();
        String newText = mChS.getFullName();
        if (!oldText.equals(newText)) {
            mChS1.setFullName(newText);
        }
        String oldEmail = mChS.getEmail();
        String newEmail = mChS.getEmail();
        if (!oldEmail.equals(newEmail)) {
            mChS1.setEmail(newEmail);
        }
        String oldPhone = mChS.getPhone();
        String newPhone = mChS1.getPhone();
        if (!Objects.equals(oldPhone, newPhone)) {
            mChS1.setPhone(newPhone);
        }
        LocalDate oldBirthDay = mChS.getBirthDay();
        LocalDate newBirthDay = mChS1.getBirthDay();
        if (!oldBirthDay.equals(newBirthDay)) {
            mChS1.setBirthDay(newBirthDay);
        }

        return mChS1;
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        mChSRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<MChS> getAll() {
        return mChSRepository.findAll();
    }
}
