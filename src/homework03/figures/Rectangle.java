package homework03.figures;

import java.util.List;

public class Rectangle extends Polygon {

    public Rectangle(double a, double b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Sides must be greater than zero.");
        }
        this.sides = List.of(a, b, a, b);
    }

    @Override
    public double findArea() {
        return sides.get(0) * sides.get(1);
    }
}
