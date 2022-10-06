package TRJavaHWs.lesson4Practice;

public class LinearAndBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4,24,1,45,23,2};
        System.out.println(linearSearch(arr, 23));
        System.out.println(binarySearch(arr, 23));

    }

    public static int linearSearch(int[] array, int toFind){
        for (int i = 0; i < array.length; i++) {
            if (toFind == array[i]){
                return i;
            }
        } return -1;
    }

    public static int binarySearch(int[] array, int toFind){
        return binSearch(array, toFind, 0, array.length-1);
    }

    public static int binSearch(int[] array, int toFind, int from, int to){
        if (from <= to){
            int mid = (from+to) / 2;
            if (toFind == array[mid]){
                return mid;
            }
            if (toFind > mid){
                return binSearch(array, toFind, mid + 1, to);
            }
            if (toFind < mid){
                return binSearch(array, toFind, from, mid-1);
            }
        }
        return -1;

    }
}
