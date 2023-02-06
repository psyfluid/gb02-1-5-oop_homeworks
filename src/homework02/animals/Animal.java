package homework02.animals;

import java.time.format.DateTimeFormatter;

public abstract class Animal {
    public static DateTimeFormatter dateFormatter;

    static {
        dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    private final String eyeColor;
    private int height;
    private int weight;

    protected Animal(int height, int weight, String eyeColor) {
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public abstract void makeSound();

    public String getInfo() {
        return String.format("%s (%s), height: %d, weight: %d, eye color: %s", this.getClass().getSimpleName(),
                this.getClass().getSuperclass().getSimpleName(), height, weight, eyeColor);
    }
}
