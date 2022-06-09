package azmat.secondprojectcompany.db.servise.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.jashtarIshteri.OfferForYouth;
import org.springframework.http.ResponseEntity;

public interface OfferForYouthService {
    OfferForYouth saveOfferForYouth(OfferForYouth offerForYouth);

    OfferForYouth update(OfferForYouth offerForYouth, Long id);

    ResponseEntity<?> deleteById(Long id);
}
