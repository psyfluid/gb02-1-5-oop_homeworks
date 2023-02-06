package homework02.animals;

public abstract class Bird extends Animal {
    private int flightHeight;

    protected Bird(int height, int weight, String eyeColor, int flightHeight) {
        super(height, weight, eyeColor);
        this.flightHeight = flightHeight;
    }

    public void fly() {
        System.out.printf("I'm flying at a height of %d meters.%n", flightHeight);
    }

    public int getFlightHeight() {
        return flightHeight;
    }

    @Override
    public String getInfo() {
        return String.format("%s, flight height: %d", super.getInfo(), flightHeight);
    }
}
