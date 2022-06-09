package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.servise.bilimBeruu.KindergartensService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Kindergartens;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KindergartensServiceImpl implements KindergartensService {
    @Override
    public Kindergartens saveKindergartens(Kindergartens kindergartens) {
        return null;
    }

    @Override
    public Kindergartens update(Kindergartens kindergartens, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
