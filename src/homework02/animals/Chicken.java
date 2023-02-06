package homework02.animals;

public class Chicken extends Bird {

    public Chicken(int height, int weight, String eyeColor, int flightHeight) {
        super(height, weight, eyeColor, flightHeight);
    }

    @Override
    public void makeSound() {
        System.out.println("Cluck cluck");
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
