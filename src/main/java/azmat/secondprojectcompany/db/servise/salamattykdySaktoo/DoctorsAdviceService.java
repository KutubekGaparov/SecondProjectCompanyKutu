package azmat.secondprojectcompany.db.servise.salamattykdySaktoo;

import azmat.secondprojectcompany.model.entity.salamattykSaktoo.DoctorsAdvice;
import org.springframework.http.ResponseEntity;

public interface DoctorsAdviceService {
    DoctorsAdvice saveDoctorsAdvice(DoctorsAdvice doctorsAdvice);

    DoctorsAdvice update(DoctorsAdvice doctorsAdvice, Long id);

    ResponseEntity<?> deleteById(Long id);
}
