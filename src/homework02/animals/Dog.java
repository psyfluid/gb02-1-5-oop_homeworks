package homework02.animals;

import java.time.LocalDate;

public class Dog extends DomesticAnimal {
    private boolean isTrained;

    public Dog(int height, int weight, String eyeColor, String name, String breed, boolean vaccinated,
               String hairColor, LocalDate birthdate, boolean isTrained) {
        super(height, weight, eyeColor, name, breed, vaccinated, hairColor, birthdate);
        this.isTrained = isTrained;
    }

    public Dog(int height, int weight, String eyeColor, String name, String breed, boolean vaccinated,
               String hairColor, LocalDate birthdate) {
        this(height, weight, eyeColor, name, breed, vaccinated, hairColor, birthdate, false);
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void train() {
        isTrained = true;
        System.out.println("Dog has been trained");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void fawn() {
        System.out.println("I'm fawning...");
    }

    @Override
    public String getInfo() {
        return String.format("%s, trained: %s", super.getInfo(), isTrained ? "yes" : "no");
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
