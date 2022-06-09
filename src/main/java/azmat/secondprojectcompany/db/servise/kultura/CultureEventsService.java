package azmat.secondprojectcompany.db.servise.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.CultureEvents;
import org.springframework.http.ResponseEntity;

public interface CultureEventsService {
    CultureEvents saveCultureEvents(CultureEvents cultureEvents);

    CultureEvents update(CultureEvents cultureEvents, Long id);

    ResponseEntity<?> deleteById(Long id);
}
