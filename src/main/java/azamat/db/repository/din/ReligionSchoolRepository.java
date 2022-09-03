package azamat.db.repository.din;

import azamat.db.model.entity.din.ReligionSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionSchoolRepository extends JpaRepository<ReligionSchool, Long> {
}