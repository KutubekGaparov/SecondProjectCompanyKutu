package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.repository.bilimPeruu.KindergartensRepository;
import azmat.secondprojectcompany.db.servise.bilimBeruu.KindergartensService;
import azmat.secondprojectcompany.exceptions.BadRequestException;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Circles;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Kindergartens;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class KindergartensServiceImpl implements KindergartensService {

    private KindergartensRepository kindergartensRepository;

    @Override
    public Kindergartens saveKindergartens(Kindergartens kindergartens) {
        return kindergartensRepository.save(kindergartens);
    }

    @Override
    @Transactional
    public Kindergartens update(Kindergartens kindergartens, Long id) {
        Kindergartens kindergartens1 = kindergartensRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = kindergartens.getKindergartensName();
        String newText = kindergartens1.getKindergartensName();
        if (!oldText.equals(newText)) {
            kindergartens1.setKindergartensName(newText);
        }
        String oldText1 = kindergartens.getDirectorFullName();
        String newText1 = kindergartens1.getDirectorFullName();
        if (!oldText1.equals(newText1)) {
            kindergartens1.setDirectorFullName(newText1);
        }
        String oldText2 = kindergartens.getCountKindergartens();
        String newText2 = kindergartens1.getCountKindergartens();
        if (!oldText2.equals(newText2)) {
            kindergartens1.setCountKindergartens(newText2);
        }
        String oldText3 = kindergartens.getLanguage();
        String newText3 = kindergartens1.getLanguage();
        if (!oldText3.equals(newText3)) {
            kindergartens1.setLanguage(newText3);
        }
        String oldText4 = kindergartens.getEmail();
        String newText4 = kindergartens1.getEmail();
        if (!oldText4.equals(newText4)) {
            kindergartens1.setEmail(newText4);
        }
        String oldText5 = kindergartens.getPhoneNumber();
        String newText5 = kindergartens1.getPhoneNumber();
        if (!oldText5.equals(newText5)) {
            kindergartens1.setPhoneNumber(newText5);
        }

        return kindergartens1;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        kindergartensRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Kindergartens> getAll() {
        return kindergartensRepository.findAll();
    }
}
