package azmat.secondprojectcompany.db.servise.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthCommitteeManager;
import org.springframework.http.ResponseEntity;

public interface YouthCommitteeManagerService {
    YouthCommitteeManager saveYouthCommitteeManager(YouthCommitteeManager committeeManager);

    YouthCommitteeManager update(YouthCommitteeManager committeeManager, Long id);

    ResponseEntity<?> deleteById(Long id);
}
