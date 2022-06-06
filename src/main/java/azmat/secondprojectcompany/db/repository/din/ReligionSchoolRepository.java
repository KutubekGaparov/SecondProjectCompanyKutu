package azmat.secondprojectcompany.db.repository.din;

import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionSchoolRepository extends JpaRepository<ReligionSchool, Long> {
}