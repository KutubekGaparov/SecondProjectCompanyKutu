package azmat.secondprojectcompany.db.servise.bilimBeruu.impl;

import azmat.secondprojectcompany.db.servise.bilimBeruu.SchoolsService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SchoolsServiceImpl implements SchoolsService {
    @Override
    public Schools saveSchools(Schools schools) {
        return null;
    }

    @Override
    public Schools update(Schools schools, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
