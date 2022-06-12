package azmat.secondprojectcompany.db.servise.bilimBeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolsService {
    Schools saveSchools(Schools schools);

    Schools update(Schools schools, Long id);

    ResponseEntity<?> deleteById(Long id);

    List<Schools> getAll();
}
