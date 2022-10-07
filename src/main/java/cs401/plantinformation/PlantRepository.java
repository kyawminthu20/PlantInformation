package cs401.plantinformation;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends CrudRepository<Plant, Long> {
    List<Plant> findByType(Boolean typeOfPlant);
    List<Plant> findByCommonName(String commonName);
    List<Plant> findByScientificName(String scientificName);
    List<Plant> findByMinGrowingZone(String minGrowingZone);
    List<Plant> findByMaxGrowingZone(String maxGrowingZone);

    List<Plant> findDistinctByIdOrderByCommonNameAsc(
            Sort sort);

    @Override
    Optional<Plant> findById(Long aLong);

    @Query("select count(p) from Plant p where upper(p.commonName) like upper(?1)")
    long checkDuplicates(String commonName);

    @Transactional
    @Modifying
    @Query("delete from Plant p where upper(p.commonName) like upper(?1)")
    int deleteDuplicate(@NonNull String commonName);


}
