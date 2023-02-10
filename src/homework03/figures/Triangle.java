package homework03.figures;

import java.util.List;

public class Triangle extends Polygon {

    public Triangle(double a, double b, double c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be greater than zero.");
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("The sum of the lengths of any two sides of a triangle must be " +
                    "greater than the length of the third side.");
        }

        this.sides = List.of(a, b, c);
    }

    @Override
    public double findArea() {
        double s = findPerimeter() / 2;
        return Math.sqrt(s * (s - sides.get(0)) * (s - sides.get(1)) * (s - sides.get(2)));
    }
}
