package azmat.secondprojectcompany.db.repository;

import azmat.secondprojectcompany.config.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    @Query("select b from Role b where b.id = ?1")
    Role getByIdRole(Long l);
}
