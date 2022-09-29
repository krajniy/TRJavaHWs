package TRJavaHWs.lesson1;

import java.util.Scanner;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input length: ");
        if (scanner.hasNext()){
            this.length = scanner.nextDouble();
        }
        System.out.println("Input width: ");
        if (scanner.hasNext()){
            this.width = scanner.nextDouble();
        }

    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double calculateArea() {
        return length * width;
    }
    public double calculatePerimeter() {
        return 2.0 * (length + width);
    }

    public static void printAriaAndPerimeter(Rectangle rectangle1, Rectangle rectangle2){
        System.out.println("First rectangle: \n" +
                "Length: " + rectangle1.getLength() + ", Width: " + rectangle1.getWidth() +
                "\nArea: " + rectangle1.calculateArea() + ", Perimeter: " + rectangle1.calculatePerimeter() +"\n" +
                "Second rectangle: \n" +
                "Length: " + rectangle2.getLength() + ", Width: " + rectangle2.getWidth() +
                "\nArea: " + rectangle2.calculateArea() + ", Perimeter: " + rectangle2.calculatePerimeter());

    }
}
