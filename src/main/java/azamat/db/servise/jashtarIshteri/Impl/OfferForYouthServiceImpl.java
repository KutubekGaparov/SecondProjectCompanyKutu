package azamat.db.servise.jashtarIshteri.Impl;

import azamat.db.repository.jashtarIshteri.OfferForYouthRepository;
import azamat.exceptions.BadRequestException;
import azamat.model.entity.jashtarIshteri.OfferForYouth;
import azamat.db.servise.jashtarIshteri.OfferForYouthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferForYouthServiceImpl implements OfferForYouthService {

    private OfferForYouthRepository repository;

    @Override
    public OfferForYouth saveOfferForYouth(OfferForYouth offerForYouth) {
        return repository.save(offerForYouth);
    }

    @Override
    @Transactional
    public OfferForYouth update(OfferForYouth offerForYouth, Long id) {
        OfferForYouth circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getOffer();
        String newText = offerForYouth.getOffer();
        if (!oldText.equals(newText)) {
            circles1.setOffer(newText);
        }
        return circles1;
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<OfferForYouth> getAll() {
        return repository.findAll();
    }
}
