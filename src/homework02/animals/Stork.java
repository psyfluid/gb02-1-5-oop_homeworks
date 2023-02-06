package homework02.animals;

public class Stork extends Bird {

    public Stork(int height, int weight, String eyeColor, int flightHeight) {
        super(height, weight, eyeColor, flightHeight);
    }

    @Override
    public void makeSound() {
        System.out.println("Clang");
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
