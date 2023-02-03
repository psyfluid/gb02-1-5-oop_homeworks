package homework01.products;

public class Diaper extends HygienicProduct {
    private final int size;
    private final int minWeight;
    private final int maxWeight;
    private final String type;

    public Diaper(String title, int price, int quantity, String unit, int piecesPerPack, int size, int minWeight,
                  int maxWeight, String type) {
        super(title, price, quantity, unit, piecesPerPack);
        this.size = size;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s, size: %d, min. weight: %d, max. weight: %d, type: %s", super.toString(), size,
                minWeight, maxWeight, type);
    }
}
