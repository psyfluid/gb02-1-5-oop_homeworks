package homework03.figures;

import java.util.List;

public abstract class Polygon extends PlainFigure {
    protected List<Double> sides;

    protected Polygon() {
    }

    public List<Double> getSides() {
        return sides;
    }

    public int getNumberOfSides() {
        return sides.size();
    }

    public double findPerimeter() {
        return sides.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append(": ");
        sb.append("sides = ").append(sides);
        return sb.toString();
    }
}
