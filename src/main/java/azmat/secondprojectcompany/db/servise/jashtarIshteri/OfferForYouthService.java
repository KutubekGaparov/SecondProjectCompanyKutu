package azmat.secondprojectcompany.db.servise.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.OfferForYouth;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferForYouthService {
    OfferForYouth saveOfferForYouth(OfferForYouth offerForYouth);

    OfferForYouth update(OfferForYouth offerForYouth, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<OfferForYouth> getAll();
}
