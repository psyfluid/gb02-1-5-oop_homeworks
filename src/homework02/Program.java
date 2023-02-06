package homework02;

import homework02.animals.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        showMainMenu(zoo);
    }

    private static void showMainMenu(Zoo zoo) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose option: ");
            System.out.println("1 - Show information about all animals in the zoo");
            System.out.println("2 - Show information about the animal");
            System.out.println("3 - Add an animal to the zoo");
            System.out.println("4 - Release an animal from the zoo");
            System.out.println("5 - Let the animal make a sound");
            System.out.println("6 - Let all the animals make a sound");
            System.out.println("7 - Let the bird fly");
            System.out.println("8 - Caress the animal");
            System.out.println("9 - Train a dog");
            System.out.println("0 - Exit");

            String action = iScanner.next();
            int actionId;
            try {
                actionId = Integer.parseInt(action);
            } catch (Exception e) {
                errorMessage();
                continue;
            }

            int index = 0;

            if (actionId == 0) {
                return;
            } else if (actionId == 2 || actionId == 4 || actionId == 5 || actionId >= 7 && actionId <= 9) {
                System.out.print("Input index of an animal: ");
                if (iScanner.hasNextInt()) {
                    index = iScanner.nextInt();
                } else {
                    errorMessage();
                    continue;
                }
            }

            switch (actionId) {
                case 1 -> zoo.printAllAnimalsInfo();
                case 2 -> System.out.println(zoo.getAnimalInfo(index));
                case 3 -> addNewAnimal(iScanner, zoo);
                case 4 -> zoo.removeAnimal(index);
                case 5 -> zoo.animalMakeSound(index);
                case 6 -> zoo.allAnimalsMakeSound();
                case 7 -> zoo.animalFly(index);
                case 8 -> zoo.animalFawn(index);
                case 9 -> zoo.animalTrain(index);
            }
        }
    }

    private static void errorMessage() {
        System.out.println("Wrong value");
    }

    private static void addNewAnimal(Scanner iScanner, Zoo zoo) {
        System.out.println("Select an animal to add to the zoo: ");
        System.out.println("1 - Cat");
        System.out.println("2 - Dog");
        System.out.println("3 - Tiger");
        System.out.println("4 - Wolf");
        System.out.println("5 - Chicken");
        System.out.println("6 - Stork");
        System.out.println("0 - Cancel and return");

        String selectedAnimal = iScanner.next();
        int selectedAnimalId;
        try {
            selectedAnimalId = Integer.parseInt(selectedAnimal);
        } catch (Exception e) {
            errorMessage();
            return;
        }

        if (selectedAnimalId < 0 || selectedAnimalId > 6) {
            errorMessage();
            return;
        } else if (selectedAnimalId == 0) {
            return;
        }

        Map<String, Object> animalArguments = new HashMap<>();
        Map<String, Object> domesticAnimalArguments = new HashMap<>();
        Map<String, Object> wildAnimalArguments = new HashMap<>();
        Map<String, Object> birdArguments = new HashMap<>();

        boolean inputError;
        inputError = getAnimalArguments(iScanner, animalArguments);
        if (inputError) {
            errorMessage();
            return;
        }

        if (selectedAnimalId == 1 || selectedAnimalId == 2) {
            inputError = getDomesticAnimalArguments(iScanner, domesticAnimalArguments);
        } else if (selectedAnimalId == 3 || selectedAnimalId == 4) {
            inputError = getWildAnimalArguments(iScanner, wildAnimalArguments);
        } else if (selectedAnimalId == 5 || selectedAnimalId == 6) {
            inputError = getBirdArguments(iScanner, birdArguments);
        }

        if (inputError) {
            errorMessage();
            return;
        }

        switch (selectedAnimalId) {
            case 1 -> addNewCat(zoo, animalArguments, domesticAnimalArguments, iScanner);
            case 2 -> addNewDog(zoo, animalArguments, domesticAnimalArguments, iScanner);
            case 3 -> addNewTiger(zoo, animalArguments, wildAnimalArguments);
            case 4 -> addNewWolf(zoo, animalArguments, wildAnimalArguments, iScanner);
            case 5 -> addNewChicken(zoo, animalArguments, birdArguments);
            case 6 -> addNewStork(zoo, animalArguments, birdArguments);
        }
    }

    private static void getStringFieldFromInput(String s, Scanner iScanner, Map<String, Object> stringObjectMap,
                                                String fieldName) {
        System.out.print(s);
        String fieldValue = iScanner.next();
        stringObjectMap.put(fieldName, fieldValue);
    }

    private static boolean getAnimalArguments(Scanner iScanner, Map<String, Object> animalArguments) {
        System.out.print("Input height: ");
        if (iScanner.hasNextInt()) {
            int height = iScanner.nextInt();
            animalArguments.put("height", height);
        } else return true;

        System.out.print("Input weight: ");
        if (iScanner.hasNextInt()) {
            int weight = iScanner.nextInt();
            animalArguments.put("weight", weight);
        } else return true;

        getStringFieldFromInput("Input eye color: ", iScanner, animalArguments, "eyeColor");

        return false;
    }

    private static boolean getDomesticAnimalArguments(Scanner iScanner, Map<String, Object> domesticAnimalArguments) {
        getStringFieldFromInput("Input name: ", iScanner, domesticAnimalArguments, "name");

        getStringFieldFromInput("Input breed: ", iScanner, domesticAnimalArguments, "breed");

        System.out.print("Is animal vaccinated? (yes - 1, no - 0): ");
        if (iScanner.hasNextInt()) {
            int vaccinated = iScanner.nextInt();
            if (vaccinated < 0 || vaccinated > 1) return true;
            domesticAnimalArguments.put("vaccinated", vaccinated == 1);
        } else return true;

        getStringFieldFromInput("Input hair color: ", iScanner, domesticAnimalArguments, "hairColor");

        System.out.print("Input birthdate (for example: 31.01.2020): ");
        try {
            String birthdateString = iScanner.next();
            LocalDate birthdate = LocalDate.parse(birthdateString, Animal.dateFormatter);
            domesticAnimalArguments.put("birthdate", birthdate);
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    private static boolean getWildAnimalArguments(Scanner iScanner, Map<String, Object> wildAnimalArguments) {
        getStringFieldFromInput("Input habitat: ", iScanner, wildAnimalArguments, "habitat");

        System.out.print("Input finding date (for example: 31.01.2020): ");
        try {
            String findingDateString = iScanner.next();
            LocalDate findingDate = LocalDate.parse(findingDateString, Animal.dateFormatter);
            wildAnimalArguments.put("findingDate", findingDate);
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    private static boolean getBirdArguments(Scanner iScanner, Map<String, Object> birdArguments) {
        System.out.print("Input flight height: ");
        if (iScanner.hasNextInt()) {
            int flightHeight = iScanner.nextInt();
            birdArguments.put("flightHeight", flightHeight);
        } else return true;

        return false;
    }

    private static void addNewCat(Zoo zoo, Map<String, Object> animalArguments,
                                  Map<String, Object> domesticAnimalArguments, Scanner iScanner) {
        boolean isHaired = false;
        System.out.print("Is cat haired? (yes - 1, no - 0): ");
        if (iScanner.hasNextInt()) {
            int isHairedInt = iScanner.nextInt();
            isHaired = (isHairedInt == 1);
        }

        Animal cat = new Cat((int) animalArguments.get("height"), (int) animalArguments.get("weight"),
                (String) animalArguments.get("eyeColor"), (String) domesticAnimalArguments.get("name"),
                (String) domesticAnimalArguments.get("breed"), (boolean) domesticAnimalArguments.get("vaccinated"),
                (String) domesticAnimalArguments.get("hairColor"), (LocalDate) domesticAnimalArguments.get("birthdate"),
                isHaired);

        zoo.addAnimal(cat);
    }

    private static void addNewDog(Zoo zoo, Map<String, Object> animalArguments,
                                  Map<String, Object> domesticAnimalArguments, Scanner iScanner) {
        boolean isTrained = false;
        System.out.print("Is dog trained? (yes - 1, no - 0): ");
        if (iScanner.hasNextInt()) {
            int isTrainedInt = iScanner.nextInt();
            isTrained = (isTrainedInt == 1);
        }

        Animal dog = new Dog((int) animalArguments.get("height"), (int) animalArguments.get("weight"),
                (String) animalArguments.get("eyeColor"), (String) domesticAnimalArguments.get("name"),
                (String) domesticAnimalArguments.get("breed"), (boolean) domesticAnimalArguments.get("vaccinated"),
                (String) domesticAnimalArguments.get("hairColor"), (LocalDate) domesticAnimalArguments.get("birthdate"),
                isTrained);

        zoo.addAnimal(dog);
    }

    private static void addNewTiger(Zoo zoo, Map<String, Object> animalArguments,
                                    Map<String, Object> wildAnimalArguments) {

        Animal tiger = new Tiger((int) animalArguments.get("height"), (int) animalArguments.get("weight"),
                (String) animalArguments.get("eyeColor"), (String) wildAnimalArguments.get("habitat"),
                (LocalDate) wildAnimalArguments.get("findingDate"));

        zoo.addAnimal(tiger);
    }

    private static void addNewWolf(Zoo zoo, Map<String, Object> animalArguments,
                                   Map<String, Object> wildAnimalArguments, Scanner iScanner) {
        boolean alphaMale = false;
        System.out.print("Is wolf alpha male? (yes - 1, no - 0): ");
        if (iScanner.hasNextInt()) {
            int alphaMaleInt = iScanner.nextInt();
            alphaMale = (alphaMaleInt == 1);
        }

        Animal wolf = new Wolf((int) animalArguments.get("height"), (int) animalArguments.get("weight"),
                (String) animalArguments.get("eyeColor"), (String) wildAnimalArguments.get("habitat"),
                (LocalDate) wildAnimalArguments.get("findingDate"), alphaMale);

        zoo.addAnimal(wolf);
    }

    private static void addNewChicken(Zoo zoo, Map<String, Object> animalArguments, Map<String, Object> birdArguments) {

        Animal chicken = new Chicken((int) animalArguments.get("height"), (int) animalArguments.get("weight"),
                (String) animalArguments.get("eyeColor"), (int) birdArguments.get("flightHeight"));

        zoo.addAnimal(chicken);
    }

    private static void addNewStork(Zoo zoo, Map<String, Object> animalArguments, Map<String, Object> birdArguments) {

        Animal stork = new Stork((int) animalArguments.get("height"), (int) animalArguments.get("weight"),
                (String) animalArguments.get("eyeColor"), (int) birdArguments.get("flightHeight"));

        zoo.addAnimal(stork);
    }
}
