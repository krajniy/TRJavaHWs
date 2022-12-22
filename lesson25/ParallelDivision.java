package TRJavaHWs.lesson25;

public class ParallelDivision {
    public static void main(String[] args) {
        int number = 5;

        //TODO:
        // В цикле разбить промежуток от Long.MIN_VALUE до Long.MAX_VALUE на 10 частей
        // Каждую часть выполнить в отдельном потоке

        int step = Integer.MAX_VALUE / 5;

        for (int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE ; max>min; min += step, max -= step ) {
            (new Thread(() -> calculateInRange(Integer.MIN_VALUE, 0, number))).start();
            (new Thread(() -> calculateInRange(0, Integer.MAX_VALUE, number))).start();


        }

    }

    private static void calculateInRange(int rangeStart, int rangeEnd, int divisor) {
        long start = System.nanoTime();

        long count = 0;

        for (int i = rangeStart; i < rangeEnd; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }

        System.out.println("=".repeat(30));
        System.out.println("Total divisible by " + divisor + ": " + count);
        System.out.println("Total elapsed time: " + (double) (System.nanoTime() - start) / 1_000_000_000);
    }
}
