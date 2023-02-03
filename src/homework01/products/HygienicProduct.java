package homework01.products;

public class HygienicProduct extends Product {
    private final int piecesPerPack;

    protected HygienicProduct(String title, int price, int quantity, String unit, int piecesPerPack) {
        super(title, price, quantity, unit);
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
