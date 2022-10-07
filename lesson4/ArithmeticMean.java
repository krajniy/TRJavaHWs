package TRJavaHWs.lesson4;

import java.util.Arrays;

public class ArithmeticMean {

    public static double arithmeticMean(int[] array){
        int sum = Arrays.stream(array).sum();
        return sum/array.length;
    }

}
