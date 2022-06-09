package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.servise.aiylCharba.TipsService;
import azmat.secondprojectcompany.model.entity.aiylCharba.Tips;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TipsServiceImpl implements TipsService {

    @Override
    public Tips saveTips(Tips tips) {
        return null;
    }

    @Override
    public Tips update(Tips tips, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
