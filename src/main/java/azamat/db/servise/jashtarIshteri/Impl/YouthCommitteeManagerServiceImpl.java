package azamat.db.servise.jashtarIshteri.Impl;

import azamat.db.repository.jashtarIshteri.YouthCommitteeManagerRepository;
import azamat.exceptions.BadRequestException;
import azamat.db.model.entity.jashtarIshteri.YouthCommitteeManager;
import azamat.db.servise.jashtarIshteri.YouthCommitteeManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class YouthCommitteeManagerServiceImpl implements YouthCommitteeManagerService {

    private YouthCommitteeManagerRepository repository;

    @Override
    public YouthCommitteeManager saveYouthCommitteeManager(YouthCommitteeManager committeeManager) {
        return repository.save(committeeManager);
    }

    @Override
    @Transactional
    public YouthCommitteeManager update(YouthCommitteeManager committeeManager, Long id) {
        YouthCommitteeManager circles1 = repository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("Id = %s has not been found", id)));

        String oldText = circles1.getInfoManager();
        String newText = committeeManager.getInfoManager();
        if (!oldText.equals(newText)) {
            circles1.setInfoManager(newText);
        }
        return circles1;
    }


    @Override
    public ResponseEntity<?> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<YouthCommitteeManager> getAll() {
        return repository.findAll();
    }
}
