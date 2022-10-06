package cs401.plantinformation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Formatter;

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

            System.out.println("Program Started");

            do{
                menuChoice = plantMenu.displayMainMenu();
                System.out.println("the return value is " + menuChoice);

                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("Adding a plant information < Common Name, Scientific Name, Type of Plant, Minimum Planting Zone, Maximum Planting Zone");
                        Plant newPlant = new Plant();
                        newPlant = plantMenu.addPlantInformation();


                    }
                    case 2 -> {
                        System.out.println("Finding Plant name by Type ");

                    }
                    case 3 -> {
                        System.out.println("Finding Plant name by Zone ");

                    }
                    case 4 -> {
                        System.out.println("Finding Plant name by Name ");

                    }
                    case 5 -> {

                        Formatter fmt = new Formatter();
                        fmt.format("%15s %15s %15s %15s\n", "Common Name", "Scientific Name", "Type of Plant", "Growing Zone");
                        long l = 0;
                        for(int i=0; i <= repository.count(); i++)
                            l = i;
                            fmt.format("%s", repository.findById(l));

                        repository.findAll();
                        System.out.println(fmt);
                    }
                    default -> {
                        System.out.println("Case not matched Error");
                    }
                }



            }while(menuChoice != 0);



        });


    }


    private void insertPlantsDemo(PlantRepository repository){
        repository.save(new Plant("Baloon Flower", "Platycodon grandiflorus", true, 2, 5));
        repository.save(new Plant("Eastern Redbud", "Cercis canadensis", false, 1, 3));
        repository.save(new Plant("Hinoki Falsecypress", "Chamaecyparis obtusa", true, 1, 4));
        repository.save(new Plant("Bee-Balm", "Monarda didyma", true, 5, 10));
    }



}
