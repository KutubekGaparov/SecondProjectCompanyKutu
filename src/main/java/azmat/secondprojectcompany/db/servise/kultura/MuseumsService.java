package azmat.secondprojectcompany.db.servise.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.Museums;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MuseumsService {
    Museums saveMuseums(Museums museums);

    Museums update(Museums museums, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Museums> getAll();
}
