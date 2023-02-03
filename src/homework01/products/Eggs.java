package homework01.products;

import java.time.LocalDate;

public class Eggs extends FoodProduct {
    private final int piecesPerPack;

    public Eggs(String title, int price, int quantity, String unit, LocalDate bestBeforeDate, int piecesPerPack) {
        super(title, price, quantity, unit, bestBeforeDate);
        this.piecesPerPack = piecesPerPack;
    }

    public int getPiecesPerPack() {
        return piecesPerPack;
    }

    @Override
    public String toString() {
        return String.format("%s, %d pcs.", super.toString(), piecesPerPack);
    }
}
