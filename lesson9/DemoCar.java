package TRJavaHWs.lesson9;

public class DemoCar {
    public static void main(String[] args) {
        Car car = new Car("Audi", 300);
        Car car1 = new Car("BMV", 301);
        Car car2 = new Car("BMV", 300);
        Car car3 = new Car("Audi", 300);


        System.out.println(car1.equals(car)); //false
        System.out.println(car2.equals(car));//false
        System.out.println(car1.equals(car2));//false
        System.out.println(car.equals(car3));//true

    }
}
