package TRJavaHWs.lesson1;

import java.util.Scanner;

public class Area {

    private double length;
    private double width;

    public Area(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double returnArea(){
        return length * width;
    }
    public void printArea(){
        System.out.println(
                "Length: " + length + ", Width: " + width +
                "\nArea: " + returnArea()
        );
    }
}
