package homework02.animals;

import java.time.LocalDate;

public class Tiger extends WildAnimal {

    public Tiger(int height, int weight, String eyeColor, String habitat, LocalDate findingDate) {
        super(height, weight, eyeColor, habitat, findingDate);
    }

    @Override
    public void makeSound() {
        System.out.println("Grr!");
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
