import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class Shape {
    private ArrayList<Point> points;
    public Shape() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            perimeter += p1.distance(p2);
        }
        return perimeter;
    }

    public double getLongestSide() {
        double longest = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            double length = p1.distance(p2);
            if (length > longest) {
                longest = length;
            }
        }
        return longest;
    }

    public double getAverageSideLength() {

        return calculatePerimeter() / points.size();
    }
}