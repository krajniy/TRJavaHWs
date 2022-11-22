package TRJavaHWs.lesson16;

import java.util.Arrays;
import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(oddSum(list));
        System.out.println(oddSumStream(list));



    }

    public static int oddSum(List<Integer> list){
        int sum = 0;
        for (Integer i : list) {
            if (i % 2 == 1){
                sum += i;
            }
        }
        return sum;
    }

    public static int oddSumStream(List<Integer> list){

        return list.stream().filter(e -> e % 2 == 1). reduce((a1, a2) -> a1+a2).get();
    }
}
