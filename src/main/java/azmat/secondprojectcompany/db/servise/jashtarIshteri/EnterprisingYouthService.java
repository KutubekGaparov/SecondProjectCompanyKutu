package azmat.secondprojectcompany.db.servise.jashtarIshteri;


import azmat.secondprojectcompany.model.entity.din.Ait;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.EnterprisingYouth;
import org.springframework.http.ResponseEntity;

public interface EnterprisingYouthService {
    EnterprisingYouth saveEnterprisingYouth(EnterprisingYouth enterprisingYouth);

    EnterprisingYouth update(EnterprisingYouth enterprisingYouth, Long id);

    ResponseEntity<?> deleteById(Long id);
}
