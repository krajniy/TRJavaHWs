package TRJavaHWs.lesson4Practice;

public class EvenAndOdds {
    public static void main(String[] args) {
        int[] evenodds = {5, 7, 2, 4, 9};
        System.out.println("evens " + evens(evenodds));
        System.out.println("odds " + odds(evenodds));

    }
    public static int evens(int[] array){
        int evens = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                evens++;
            }
        }
        return evens;
    }

    public static int odds(int[] array){
        int odds = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                odds++;
            }
        }
        return odds;
    }
}
