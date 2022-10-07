package cs401.plantinformation;

import cs401.plantinformation.Plant;
import java.util.*;

public class Menu {

    int mainMenuChoice;
    boolean valid = false;

    public int displayMainMenu(){
        System.out.println("\nPlants, v0.1");
        System.out.println("=============");

        do{
            Scanner stdin = new Scanner(System.in);
            System.out.println("Enter command : \n " +
                    "0 to Quit\n " +
                    "1 to Add\n " +
                    "2 to Find by type\n " +
                    "3 to Find by Minimum Growing Year\n " +
                    "4 to Find by Maximum Growing Year\n " +
                    "5 to Find by Common Name\n " +
                    "6 to Find by Scientific Name\n " +
                    "7 to Display all information\n >>>>>> ");
            mainMenuChoice = stdin.nextInt();

            if(mainMenuChoice < 0 || mainMenuChoice > 7)
            {
                valid = false;
                System.out.println("Invalid Input\n");
            } else if (mainMenuChoice == 0)
            {
                System.exit(0);
            }
            else {
                valid = true;
            }

            System.out.println("You have entered : "+ mainMenuChoice + "\n");

        }while(!valid);

        return mainMenuChoice;

    }

    public Plant addPlantInformation()
    {
        Plant newPlant = new Plant();
        Scanner stdin = new Scanner(System.in);
        System.out.printf("Please enter Common Name : ");
        newPlant.setCommonName(stdin.next());
        stdin = new Scanner(System.in);
        System.out.printf("Please enter Scientific Name : ");
        newPlant.setScientificName(stdin.next());
        stdin = new Scanner(System.in);
        boolean b = false;
        do {
            System.out.printf("Please enter Type of Plant (false - > Tree, true - > Perennial) : ");
            try {
                Scanner n = new Scanner(System.in);
                boolean bn = n.nextBoolean();
                if (bn == true) {
                    newPlant.setTypeOfPlant(true);
                } else if (bn == false) {
                    newPlant.setTypeOfPlant(false);
                }
                b = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }
        } while (!b);

        stdin = new Scanner(System.in);
        System.out.printf("Please enter Minimum Growing Zone : ");
        newPlant.setMinGrowingZone(stdin.nextInt());
        stdin = new Scanner(System.in);
        System.out.printf("Please enter Maximum Growing Zone : ");
        newPlant.setMaxGrowingZone(stdin.nextInt());

        return newPlant;
    }

}
