package homework01.products;

import java.time.LocalDate;

public class Bread extends FoodProduct {
    private final String flourType;

    public Bread(String title, int price, int quantity, String unit, LocalDate bestBeforeDate, String flourType) {
        super(title, price, quantity, unit, bestBeforeDate);
        this.flourType = flourType;
    }

    public String getFlourType() {
        return flourType;
    }

    @Override
    public String toString() {
        return String.format("%s, flour: %s", super.toString(), flourType);
    }
}
