package azamat.db.servise.bilimBeruu;

import azamat.db.model.entity.bilimBeruu.Kindergartens;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

public interface KindergartensService {
    Kindergartens saveKindergartens(Kindergartens kindergartens);

    Kindergartens update(Kindergartens kindergartens, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Kindergartens> getAll();

    LinkedHashMap<String, String> uploadFile(MultipartFile firstPhoto, Long id);

}
