package azamat.db.servise.jashtarIshteri;


import azamat.db.model.entity.jashtarIshteri.EnterprisingYouth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface EnterprisingYouthService {
    EnterprisingYouth saveEnterprisingYouth(EnterprisingYouth enterprisingYouth);

    EnterprisingYouth update(EnterprisingYouth enterprisingYouth, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<EnterprisingYouth> getAll();
    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
