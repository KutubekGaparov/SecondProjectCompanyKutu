package azmat.secondprojectcompany.db.servise.bilimBeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.Kindergartens;
import org.springframework.http.ResponseEntity;

public interface KindergartensService {
    Kindergartens saveKindergartens(Kindergartens kindergartens);

    Kindergartens update(Kindergartens kindergartens, Long id);

    ResponseEntity<?> deleteById(Long id);
}
