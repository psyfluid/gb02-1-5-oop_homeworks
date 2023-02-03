package homework01.products;

public class Beverage extends Product {
    private final int volume;

    protected Beverage(String title, int price, int quantity, String unit, int volume) {
        super(title, price, quantity, unit);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("%s, vol.: %d", super.toString(), volume);
    }
}
