package see.ashwini.advanture.Model1;

import see.ashwini.advanture.Model.Burglar;
import see.ashwini.advanture.Model.Entity;
import see.ashwini.advanture.Model.Resident;

import java.util.Scanner;

public class Game {

    private static Burglar burglar;
    private static Resident resident;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private static boolean fryingPanFound = false;
    private static final String HALL = "hall";
    private static final String BEDROOM = "bedroom";
    private static final String KITCHEN = "kitchen";
    private static final String KONTORET = "kontoret";
    private static final String LIVING_ROOM = "living room";
    private static String currentLocation = LIVING_ROOM;

    public static void printWelcomeMenu() {
        System.out.println("Welcome to the advanture game!");
        System.out.println("You are sleeping,you heared the sound and goes in search of burglar");
    }

    private static void fightOneRound() {

        executeAttack(resident, burglar);
        if (burglar.isConcious()) {
            executeAttack(burglar, resident);

        }
        else if(!resident.isConcious() || !burglar.isConcious()) {
            running = false;
        }




    }

    static void executeAttack(Entity attacker, Entity defender) {
        attacker.punch(defender);
        System.out.println(attacker.getRole() + " " + "attacker" + " " + defender.getRole());
        if (defender.isConcious()) {
            System.out.println(defender.getRole() + " " + "still he is alive" + " " + defender.getHealth());
        } else {
            System.out.println(defender.getRole() + "he is dead!");
            running = false;
        }

    }

    public void start() {
        resident = new Resident("Resident", 12, 3);
        burglar = new Burglar("Burglar", 12, 4);
        printWelcomeMenu();

        while (running) {
            String Input = getUserInput();
            processInput(Input);

        }
    }

    private String getUserInput() {
        System.out.println("Enter the input");
        return scanner.nextLine();
    }

    static boolean processInput(String userInput) {

        switch (userInput) {
            case "bedroom" -> bedroom();
            case "kitchen" -> kitchen();
            case "hall" -> hall();
            case "office" -> kontoret();
            case "livingroom" -> livingroom();
            case "fight" -> fightOneRound();
            case "quite" -> {
                running = false;
            }
            default -> System.out.println("Invalid input");

        }
        return false;
    }

    private static void livingroom() {

        if (!currentLocation.equals(LIVING_ROOM)) {
            currentLocation = LIVING_ROOM;
            System.out.println("You are in the living room, where would you like to go now?");

        } else {
            System.out.println("go to the central place first");
        }
    }

    private static void hall() {

        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = HALL;
            System.out.println("You are in the hall,the fight takes place here");
            System.out.println(" Would you like to do? fight/Quit");
            String response = scanner.nextLine();
            if (response.equals("fight")) {
                while (burglar.isConcious() && resident.isConcious()) {
                    //processInput(response);
                    fightOneRound();
                }

            } else {
                System.out.println("No fight");
            }
        } else {
            System.out.println("Go the central place first");
        }
    }

    private static void bedroom() {

        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = BEDROOM;
            System.out.println("you are in the bedroom,nothing special happens here");
        } else
            System.out.println("Go to the central place first");

    }

    private static void kitchen() {

        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = KITCHEN;
            System.out.println("Its kitchen");
            if (!fryingPanFound) {
                System.out.println("Frying pan found,would you like to pick it up?(yes/no)");
                String choice = scanner.next();
                if (choice.equals("yes")) {
                    resident.addDamage(3);
                    // increase damage from 3 to 6
                    fryingPanFound = true;
                    System.out.println("you picked up the frying pan,  damage has increased");

                } else {

                    System.out.println("you decided to leave the frying pan");

                }
            } else {
                System.out.println("There is no frying pan");
            }
        } else {
            System.out.println("Go to the living room first");

        }
    }

    private static void kontoret() {

        if (currentLocation.equals(LIVING_ROOM)) {
            currentLocation = KONTORET;
            System.out.println("you are at the kontoret,would you like to call police?");
            if (!burglar.isConcious()) {
                System.out.println("You see a phone,would you like to call police ?(yes/no)");
                String choice = scanner.next();
                if (choice.equals("yes")) {
                    System.out.println("You are now safe,Police are arriving");
                    running = false;
                } else {
                    System.out.println("If you are too stressed to think about calling the police");
                }
            } else {
                System.out.println("Theief is still conscious");
            }
        } else
            System.out.println("Go to the living room first");

    }


}








