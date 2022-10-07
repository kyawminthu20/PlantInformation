package cs401.plantinformation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Long> {
    long countByCommonName(String commonName);

    long countByScientificName(String scientificName);


    List<Plant> findByCommonName(String s);
    List<Plant> findByScientificName(String s);
    List<Plant> findByTypeOfPlant(Boolean b);
    List<Plant> findByMinGrowingZone(int i);
    List<Plant> findByMaxGrowingZone(int i);

    List<Plant> getAllByAllIgnoreCase();



}
