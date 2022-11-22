package TRJavaHWs.lesson16;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class ConsumerPractice {
    public static void main(String[] args) {

        Consumer<Number> numberConsumer = number -> {
            if (number instanceof Integer) {
                IntConsumer intConsumer = intNumber -> {
                    System.out.println("Integer " + intNumber);
                };
                intConsumer.accept((Integer) number);
            }
            if (number instanceof Long) {
                LongConsumer longConsumer = longNumber -> {
                    System.out.println("Long " + longNumber);
                };
                longConsumer.accept((Long) number);


            }
            if (number instanceof Double) {
                DoubleConsumer doubleConsumer = doubleNumber -> {
                    System.out.println("Double " + doubleNumber);
                };
                doubleConsumer.accept((Double) number);

            }
        };

        numberConsumer.accept(100);
        numberConsumer.accept(100.0);
        numberConsumer.accept(100L);



    }
}
