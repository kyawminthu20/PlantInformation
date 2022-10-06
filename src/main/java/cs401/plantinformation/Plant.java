package cs401.plantinformation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plant {
    @Id
    @GeneratedValue
    private Long id;
    private String commonName;
    private String scientificName;
    private boolean typeOfPlant;
    private int minGrowingZone;
    private int maxGrowingZone;

    public Plant() {

    }

    public Plant(String commonName, String scientificName, boolean typeOfPlant, int minGrowingZone, int maxGrowingZone) {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.typeOfPlant = typeOfPlant;
        this.minGrowingZone = minGrowingZone;
        this.maxGrowingZone = maxGrowingZone;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public boolean isTypeOfPlant() {
        return typeOfPlant;
    }

    public void setTypeOfPlant(boolean typeOfPlant) {
        this.typeOfPlant = typeOfPlant;
    }

    public int getMinGrowingZone() {
        return minGrowingZone;
    }

    public void setMinGrowingZone(int minGrowingZone) {
        this.minGrowingZone = minGrowingZone;
    }

    public int getMaxGrowingZone() {
        return maxGrowingZone;
    }



    public void setMaxGrowingZone(int maxGrowingZone) {
        this.maxGrowingZone = maxGrowingZone;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", commonName='" + commonName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", typeOfPlant=" + typeOfPlant +
                ", minGrowingZone=" + minGrowingZone +
                ", maxGrowingZone=" + maxGrowingZone +
                '}';
    }
}
