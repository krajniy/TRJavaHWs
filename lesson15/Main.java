package TRJavaHWs.lesson15;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //TODO
        // Используя примитивные интерфейсы Supplier,
        // получить рандомные значения для примитивных типов int, double, long, boolean
        // И вывести их в консоль

        Random random = new Random();

        Supplier<Integer> integerSupplier = () -> (random.nextInt());
        int i = integerSupplier.get();

        Supplier<Double> doubleSupplier = () -> (random.nextDouble());
        double d = doubleSupplier.get();

        Supplier<Long> longSupplier = () -> (random.nextLong());
        long l = longSupplier.get();

        Supplier<Boolean> booleanSupplier = () -> random.nextBoolean();
        boolean b = booleanSupplier.get();

        System.out.println(i);
        System.out.println(d);
        System.out.println(l);
        System.out.println(b);




    }


}
