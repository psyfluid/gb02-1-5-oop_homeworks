package homework01.products;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Milk extends Beverage {
    private final double fatContent;
    private final LocalDate bestBeforeDate;

    public Milk(String title, int price, int quantity, String unit, int volume, double fatContent, LocalDate bestBeforeDate) {
        super(title, price, quantity, unit, volume);
        this.fatContent = fatContent;
        this.bestBeforeDate = bestBeforeDate;
    }

    public double getFatContent() {
        return fatContent;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("%s, fat: %.1f%%, best before: %s", super.toString(), fatContent,
                bestBeforeDate.format(formatter));
    }
}
