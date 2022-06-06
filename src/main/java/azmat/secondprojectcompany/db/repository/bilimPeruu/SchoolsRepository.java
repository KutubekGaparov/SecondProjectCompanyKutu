package azmat.secondprojectcompany.db.repository.bilimPeruu;

import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepository extends JpaRepository<Schools, Long> {
}