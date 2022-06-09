package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.servise.aiylCharba.GrainGrowingService;
import azmat.secondprojectcompany.model.entity.aiylCharba.GrainGrowing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GrainGrowingServiceImpl implements GrainGrowingService{
    @Override
    public GrainGrowing saveGrainGraving(GrainGrowing grainGrowing) {
        return null;
    }

    @Override
    public GrainGrowing update(GrainGrowing grainGrowing, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
