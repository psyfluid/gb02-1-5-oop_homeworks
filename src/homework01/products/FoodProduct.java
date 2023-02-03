package homework01.products;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FoodProduct extends Product {
    private final LocalDate bestBeforeDate;

    protected FoodProduct(String title, int price, int quantity, String unit, LocalDate bestBeforeDate) {
        super(title, price, quantity, unit);
        this.bestBeforeDate = bestBeforeDate;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("%s, best before: %s", super.toString(), bestBeforeDate.format(formatter));
    }
}
