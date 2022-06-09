package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.servise.kultura.CulturalFiguresService;
import azmat.secondprojectcompany.model.entity.Kultura.CulturalFigures;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CulturalFiguresServiceImpl implements CulturalFiguresService {
    @Override
    public CulturalFigures saveCulturalFigures(CulturalFigures culturalFigures) {
        return null;
    }

    @Override
    public CulturalFigures update(CulturalFigures culturalFigures, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
