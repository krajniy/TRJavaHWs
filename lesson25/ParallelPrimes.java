package TRJavaHWs.lesson25;

public class ParallelPrimes {
    public static void main(String[] args) {

        for (int i = 2, step = 200000; i <= 800002; i += step) {
            int start = i;
            int end = i + step;
            Thread t1 = new Thread(() -> calculateInRange(start, end));
            t1.start();

        }

    }

    private static void calculateInRange(int rangeStart, int rangeEnd) {
        System.out.println("Started");
        long start = System.nanoTime();

        int count = 0;

        for (int i = rangeStart; i < rangeEnd; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println("=".repeat(30));
        System.out.println("Total number of primes: " + count);
        System.out.println("Total elapsed time: " + (double) (System.nanoTime() - start) / 1_000_000_000);
    }
}
