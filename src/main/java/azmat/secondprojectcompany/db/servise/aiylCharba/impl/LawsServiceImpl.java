package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.servise.aiylCharba.LawsService;
import azmat.secondprojectcompany.model.entity.aiylCharba.Laws;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LawsServiceImpl implements LawsService {

    @Override
    public Laws saveLaws(Laws laws) {
        return null;
    }

    @Override
    public Laws update(Laws laws, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
