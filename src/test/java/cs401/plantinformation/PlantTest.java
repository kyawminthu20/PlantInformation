package cs401.plantinformation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {

    @Test
    void setPlantCommonName() {
        Plant tPlant = new Plant();

        tPlant.setCommonName("Coconut");

        assertEquals("Coconut", tPlant.getCommonName());

    }

    @Test
    void getPlantCommonName() throws Exception{

        Plant tPlant = new Plant();

        tPlant.setCommonName("Orange");

        assertEquals("Papaya", tPlant.getCommonName());
    }


}