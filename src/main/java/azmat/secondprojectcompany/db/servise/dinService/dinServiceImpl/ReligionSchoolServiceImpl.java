package azmat.secondprojectcompany.db.servise.dinService.dinServiceImpl;

import azmat.secondprojectcompany.db.servise.dinService.ReligionSchoolService;
import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReligionSchoolServiceImpl implements ReligionSchoolService {
    @Override
    public ReligionSchool saveReligionSchool(ReligionSchool religionSchool) {
        return null;
    }

    @Override
    public ReligionSchool update(ReligionSchool religionSchool, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
