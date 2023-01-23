import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\Alexey\\Desktop\\file25.txt "));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(", ");
                if (parts.length != 2) {
                    System.out.println("Error: Invalid point format: " + line);
                    continue;
                }
                try {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    Point point = new Point(x, y);
                    shape.addPoint(point);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid point format: " + line);
                    continue;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: file1.txt");
            return;
        }
        double perimeter = shape.calculatePerimeter();
        System.out.println("Shape perimeter: " + perimeter);
        double longestSide = shape.getLongestSide();
        System.out.println("Longest side: " + longestSide);
        double averageSideLength = shape.getAverageSideLength();
        System.out.println("Average side length: " + averageSideLength);


    }
}

