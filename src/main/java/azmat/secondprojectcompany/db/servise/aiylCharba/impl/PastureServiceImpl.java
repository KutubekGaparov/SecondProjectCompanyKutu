package azmat.secondprojectcompany.db.servise.aiylCharba.impl;

import azmat.secondprojectcompany.db.servise.aiylCharba.PastureServise;
import azmat.secondprojectcompany.model.entity.aiylCharba.Pasture;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PastureServiceImpl implements PastureServise {

    @Override
    public Pasture savePasture(Pasture pasture) {
        return null;
    }

    @Override
    public Pasture update(Pasture pasture, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
