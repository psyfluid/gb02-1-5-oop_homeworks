package homework03.figures;

public class Circle extends PlainFigure {

    private final double radius;

    public Circle(double radius) throws IllegalArgumentException {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double findCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle: ");
        sb.append("radius = ").append(radius);
        return sb.toString();
    }
}
