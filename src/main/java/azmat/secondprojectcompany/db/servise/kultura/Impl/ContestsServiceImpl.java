package azmat.secondprojectcompany.db.servise.kultura.Impl;

import azmat.secondprojectcompany.db.servise.kultura.ContestsService;
import azmat.secondprojectcompany.model.entity.Kultura.Contests;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContestsServiceImpl implements ContestsService {
    @Override
    public Contests saveContests(Contests contests) {
        return null;
    }

    @Override
    public Contests update(Contests contests, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }
}
