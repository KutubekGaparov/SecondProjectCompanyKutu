package azamat.db.servise.salamattykdySaktoo;

import azamat.db.model.entity.salamattykSaktoo.DoctorsAdvice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorsAdviceService {
    DoctorsAdvice saveDoctorsAdvice(DoctorsAdvice doctorsAdvice);

    DoctorsAdvice update(DoctorsAdvice doctorsAdvice, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<DoctorsAdvice> getAll();
}
