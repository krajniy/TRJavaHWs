package TRJavaHWs.lesson1;

import java.io.IOException;
import java.util.Scanner;

public class RectangleMain {
    public static void main(String[] args) {
        //Первый вариант, параметры передаются в конструктор Rectangle
        Rectangle rectangle1 = new Rectangle(4, 5);
        Rectangle rectangle2 = new Rectangle(5, 8);

        Rectangle.printAriaAndPerimeter(rectangle1, rectangle2);

//        Конструктор по умолчанию Rectangle спрашивает пользователя
//        Rectangle rectangle3 = new Rectangle();
//        Rectangle rectangle4 = new Rectangle();
//        Rectangle.printAriaAndPerimeter(rectangle3, rectangle4;


//        Решение по условию:
//        Напишите программу для печати площади прямоугольника, создав класс с именем 'Area',
//        принимающий значения его длины и ширины в качестве параметров своего конструктора и
//        имеющий метод с именем 'returnArea', который возвращает площадь прямоугольника.
//        Длина и ширина прямоугольника вводятся с клавиатуры.

        try {
            new Area(scanLength(), scanWidth()).printArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double scanWidth() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input width: ");
        if (scanner.hasNext()) {
            return scanner.nextDouble();
        } else throw new Exception();
    }
    public static double scanLength() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input length: ");
        if (scanner.hasNext()) {
            return scanner.nextDouble();
        } else throw new Exception();
    }
}
