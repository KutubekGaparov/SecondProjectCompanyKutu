package azmat.secondprojectcompany.db.servise.kultura;

import azmat.secondprojectcompany.model.entity.Kultura.CultureEvents;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultureEventsService {
    CultureEvents saveCultureEvents(CultureEvents cultureEvents);

    CultureEvents update(CultureEvents cultureEvents, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<CultureEvents> getAll();
}
