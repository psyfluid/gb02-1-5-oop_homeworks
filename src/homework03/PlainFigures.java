package homework03;

import homework03.figures.Circle;
import homework03.figures.PlainFigure;
import homework03.figures.Polygon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PlainFigures implements Iterable<PlainFigure> {
    private List<PlainFigure> figures;
    private int index;

    public PlainFigures() {
        this.figures = new ArrayList<>();
        this.index = 0;
    }

    public void addFigure(PlainFigure figure) {
        figures.add(figure);
    }

    public void removeFigure(int index) {
        figures.remove(index);
    }

    public void replaceFigure(int index, PlainFigure figure) {
        figures.set(index, figure);
    }

    public void sortByArea() {
        figures.sort(Comparator.comparingDouble(figure -> figure.findArea()));
    }

    private boolean emptyCollection() {
        if (figures.isEmpty()) {
            System.out.println("There are no figures.");
            return true;
        }
        return false;
    }

    public void printAllFiguresInfo(boolean includePerimeter, boolean includeArea) {
        if (emptyCollection()) return;
        int i = 0;
        for (PlainFigure figure : this) {
            System.out.printf("%d. ", i++);
            System.out.printf("%s%s%s%n", figure,
                    includePerimeter ? String.format(", %s", getPerimeter(figure)) : "",
                    includeArea ? String.format(", %s", getArea(figure)) : "");
        }
    }

    public String getPerimeter(PlainFigure figure) {
        String pTitle = "";
        double p = 0;
        if (figure instanceof Polygon) {
            p = ((Polygon) figure).findPerimeter();
            pTitle = "perimeter";
        } else if (figure instanceof Circle) {
            p = ((Circle) figure).findCircumference();
            pTitle = "circumference";
        } else {
            return "unknown perimeter";
        }
        return String.format("%s = %.2f", pTitle, p);
    }

    public String getArea(PlainFigure figure) {
        return String.format("area = %.2f", figure.findArea());
    }

    @Override
    public Iterator<PlainFigure> iterator() {
        Iterator<PlainFigure> iterator = new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < figures.size();
            }

            @Override
            public PlainFigure next() {
                return figures.get(index++);
            }
        };

        return iterator;
    }
}
