package homework03;

import homework03.figures.Circle;
import homework03.figures.Rectangle;
import homework03.figures.Square;
import homework03.figures.Triangle;

public class Program {
    public static void main(String[] args) {
        PlainFigures figures = new PlainFigures();
        figures.addFigure(new Square(5));
        figures.addFigure(new Rectangle(3, 5));
        figures.addFigure(new Triangle(3, 4, 2));
        figures.addFigure(new Circle(6));

        System.out.println("All figures:");
        figures.printAllFiguresInfo(true, true);
        System.out.println();

        System.out.println("Sort by area:");
        figures.sortByArea();
        figures.printAllFiguresInfo(true, true);
        System.out.println();

        System.out.println("Remove figure with index 1:");
        figures.removeFigure(1);
        figures.printAllFiguresInfo(true, true);
        System.out.println();

        System.out.println("Replace figure with index 0:");
        figures.replaceFigure(0, new Circle(3));
        figures.printAllFiguresInfo(true, true);

    }
}
