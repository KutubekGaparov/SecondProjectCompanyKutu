package azmat.secondprojectcompany.db.repository.bilimPeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.DrivingSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingSchoolRepository extends JpaRepository<DrivingSchool, Long> {
}