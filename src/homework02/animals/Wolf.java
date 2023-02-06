package homework02.animals;

import java.time.LocalDate;

public class Wolf extends WildAnimal {
    private boolean alphaMale;

    public Wolf(int height, int weight, String eyeColor, String habitat, LocalDate findingDate, boolean alphaMale) {
        super(height, weight, eyeColor, habitat, findingDate);
        this.alphaMale = alphaMale;
    }

    public Wolf(int height, int weight, String eyeColor, String habitat, LocalDate findingDate) {
        super(height, weight, eyeColor, habitat, findingDate);
        this.alphaMale = false;
    }

    public boolean isAlphaMale() {
        return alphaMale;
    }

    public void setAlphaMale(boolean alphaMale) {
        this.alphaMale = alphaMale;
    }

    @Override
    public void makeSound() {
        System.out.println("Owooooo!");
    }

    @Override
    public String getInfo() {
        return String.format("%s, alpha male: %s", super.getInfo(), isAlphaMale() ? "yes" : "no");
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
