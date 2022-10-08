package cs401.plantinformation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.*;

@SpringBootApplication
public class PlantInformationApplication {

    public static void main(String[] args) {

        SpringApplication.run(PlantInformationApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(PlantRepository repository){
        return (args -> {
            insertPlantsDemo(repository);
            System.out.println("DataBase initialized");

            int menuChoice;
            Menu plantMenu = new Menu();
            List<Plant> plantList = new ArrayList<>();

            System.out.println("Program Started");
// MENU DISPLAY AND RETURN VALUE IS CHECKED AGAINST THE CASES

            do{
                menuChoice = plantMenu.displayMainMenu();
                //System.out.println("the return value is " + menuChoice);


                // CASE 1 TO ADD PLANT INFORMATION, NEW PLANT INFORMATION ADDING THROUGH MENU CLASS
                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("Adding a plant information < Common Name, Scientific Name, Type of Plant, Minimum Planting Zone, Maximum Planting Zone");
                        Plant newPlant = new Plant();
                        newPlant = plantMenu.addPlantInformation();

                        //USING REPOSITORY SAVE TO ADD PLANT INFORMATION

                        repository.save(newPlant);

                    }

                    // CASES 2-7 USED REPOSITORY METHODS UNDER PLANT REPOSITORY TO GET THE LIST OF PLANTS THROUGH JPA SPRING BUILT IN FUNCTIONS
                    case 2 -> {

                        System.out.println("Finding Plant name by Type ");
                        Scanner stdin = new Scanner(System.in);
                        boolean b = false;
                        plantList.clear();
                        System.out.printf("Please enter Type of Plant to Find (type Tree or Perennial) :");
                        String typeToSearch = stdin.next();

                        if (typeToSearch.equalsIgnoreCase("Tree"))
                        {
                            plantList= repository.findByTypeOfPlant(false);
                        } else if (typeToSearch.equalsIgnoreCase("Perennial")) {
                            plantList = repository.findByTypeOfPlant(true);
                        }

                        Formatter fmt = new Formatter();
                        fmt.format("%25s %25s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Min Growing Zone", "Max Growing Zone");


                        for(Plant i: plantList)
                        {
                            fmt.format("%25s %25s %15s %15s %15s\n", i.getCommonName(), i.getScientificName(), i.getTypeOfPlant(), i.getMinGrowingZone(), i.getMaxGrowingZone());
                        }
                        System.out.println(fmt);


                    }
                    case 3 -> {
                        System.out.println("Finding Plant name by Minimum Year ");

                        Scanner stdin = new Scanner(System.in);
                        boolean b = false;
                        plantList.clear();
                        System.out.printf("Please enter minimum Year (integers 0 - 9 [0-9]) :");
                        int minYear = stdin.nextInt();

                        plantList= repository.findByMinGrowingZone(minYear);

                        Formatter fmt = new Formatter();
                        fmt.format("%25s %25s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Min Growing Zone", "Max Growing Zone");

                        for(Plant i: plantList)
                        {
                            fmt.format("%25s %25s %15s %15s %15s\n", i.getCommonName(), i.getScientificName(), i.getTypeOfPlant(), i.getMinGrowingZone(), i.getMaxGrowingZone());
                        }
                        System.out.println(fmt);

                    }
                    case 4 -> {
                        System.out.println("Finding Plant name by Maximum Year ");

                        Scanner stdin = new Scanner(System.in);
                        boolean b = false;
                        plantList.clear();
                        System.out.printf("Please enter maximum Year (integers 0 - 9 [0-9]) :");
                        int maxYear = stdin.nextInt();

                        plantList= repository.findByMinGrowingZone(maxYear);

                        Formatter fmt = new Formatter();
                        fmt.format("%25s %25s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Min Growing Zone", "Max Growing Zone");

                        for(Plant i: plantList)
                        {
                            fmt.format("%25s %25s %15s %15s %15s\n", i.getCommonName(), i.getScientificName(), i.getTypeOfPlant(), i.getMinGrowingZone(), i.getMaxGrowingZone());
                        }
                        System.out.println(fmt);

                    }

                    case 5 -> {
                        System.out.println("Finding Plant name by Common Name");

                        Scanner stdin = new Scanner(System.in);
                        boolean b = false;
                        plantList.clear();
                        System.out.printf("Please enter Common Name to search :");
                        String cName = stdin.next();

                        plantList= repository.findByCommonName(cName);

                        Formatter fmt = new Formatter();
                        fmt.format("%25s %25s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Min Growing Zone", "Max Growing Zone");

                        for(Plant i: plantList)
                        {
                            fmt.format("%25s %25s %15s %15s %15s\n", i.getCommonName(), i.getScientificName(), i.getTypeOfPlant(), i.getMinGrowingZone(), i.getMaxGrowingZone());
                        }
                        System.out.println(fmt);

                    }

                    case 6 -> {
                        System.out.println("Finding Plant name by Scientific Name ");

                        Scanner stdin = new Scanner(System.in);
                        boolean b = false;
                        plantList.clear();
                        System.out.printf("Please enter Scientific Name to search :");
                        String sName = stdin.next();

                        plantList= repository.findByScientificName(sName);

                        Formatter fmt = new Formatter();
                        fmt.format("%25s %25s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Min Growing Zone", "Max Growing Zone");

                        for(Plant i: plantList)
                        {
                            fmt.format("%25s %25s %15s %15s %15s\n", i.getCommonName(), i.getScientificName(), i.getTypeOfPlant(), i.getMinGrowingZone(), i.getMaxGrowingZone());
                        }
                        System.out.println(fmt);

                    }
                    case 7 -> {

                        Formatter fmt = new Formatter();
                        fmt.format("%25s %25s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Min Growing Zone", "Max Growing Zone");

                        plantList.clear();
                        plantList = repository.getAllByAllIgnoreCase();
                        for(Plant i: plantList)
                        {
                            fmt.format("%25s %25s %15s %15s %15s\n", i.getCommonName(), i.getScientificName(), i.getTypeOfPlant(), i.getMinGrowingZone(), i.getMaxGrowingZone());
                        }

                        System.out.println(fmt);
                    }
                    default -> {
                        System.out.println("Case not matched Error");
                    }
                }
            }while(menuChoice != 0);
        });
    }

    // INSERT PLANT DEMO IS USED TO MAKE PLANT INFORMATION READY WHEN IT IS RUN - TESTING PURPOSE
    private void insertPlantsDemo(PlantRepository repository){
        repository.save(new Plant("Baloon Flower", "Platycodon grandiflorus", true, 2, 5));
        repository.save(new Plant("Eastern Redbud", "Cercis canadensis", false, 1, 3));
        repository.save(new Plant("Hinoki Falsecypress", "Chamaecyparis obtusa", true, 1, 4));
        repository.save(new Plant("Bee-Balm", "Monarda didyma", true, 5, 10));
    }



}
