package homework01.products;

public class Product {
    private final String title;
    private final String unit;
    private int price;
    private int quantity;

    protected Product(String title, int price, int quantity, String unit) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, price: %d, %d %s", this.getClass().getSimpleName(), title, price, quantity, unit);
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }
}
