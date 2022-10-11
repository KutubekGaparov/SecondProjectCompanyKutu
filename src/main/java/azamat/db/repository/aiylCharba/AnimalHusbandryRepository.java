package azamat.db.repository.aiylCharba;

import azamat.db.model.entity.aiylCharba.AnimalHusbandry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalHusbandryRepository extends JpaRepository<AnimalHusbandry, Long> {

    @Modifying
    @Query("delete  from AnimalHusbandry a  where a.fileInformation.keyOfPhoto = ?1")
    void deleteByName(String fileName);

}