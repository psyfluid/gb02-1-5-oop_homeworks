package homework01.products;

public class ToiletPaper extends HygienicProduct {
    private final int numberOfLayers;

    public ToiletPaper(String title, int price, int quantity, String unit, int piecesPerPack, int numberOfLayers) {
        super(title, price, quantity, unit, piecesPerPack);
        this.numberOfLayers = numberOfLayers;
    }

    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    @Override
    public String toString() {
        return String.format("%s, %d layers", super.toString(), numberOfLayers);
    }
}
