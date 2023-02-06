package homework02.animals;

import java.time.LocalDate;

public class Cat extends DomesticAnimal {

    private boolean isHaired;

    public Cat(int height, int weight, String eyeColor, String name, String breed, boolean vaccinated,
               String hairColor, LocalDate birthdate, boolean isHaired) {
        super(height, weight, eyeColor, name, breed, vaccinated, hairColor, birthdate);
        this.isHaired = isHaired;
    }

    public boolean isHaired() {
        return isHaired;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void fawn() {
        System.out.println("Purr...");
    }

    @Override
    public String getInfo() {
        return String.format("%s, haired: %s", super.getInfo(), isHaired ? "yes" : "no");
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
