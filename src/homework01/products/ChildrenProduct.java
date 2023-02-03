package homework01.products;

public class ChildrenProduct extends Product {
    private final int minimumAge;
    private final boolean hypoallergenic;

    protected ChildrenProduct(String title, int price, int quantity, String unit, int minimumAge, boolean hypoallergenic) {
        super(title, price, quantity, unit);
        this.minimumAge = minimumAge;
        this.hypoallergenic = hypoallergenic;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public boolean isHypoallergenic() {
        return hypoallergenic;
    }

    @Override
    public String toString() {
        return String.format("%s, min. age: %d, hypoallergenic: %s", super.toString(),
                minimumAge,
                hypoallergenic ? "yes" : "no");
    }
}
