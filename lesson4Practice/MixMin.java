package TRJavaHWs.lesson4Practice;

public class MixMin {
    public static void main(String[] args) {
        int[] minmax = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        System.out.println(min(minmax));
        System.out.println(max(minmax));

    }

    public static int min(int[] array){
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= result){
                result = array[i];
            }
        }
        return result;
    }

    public static int max(int[] array){
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= result){
                result = array[i];
            }
        }
        return result;
    }
}
