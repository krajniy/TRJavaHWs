package TRJavaHWs.lesson21;

public class FinallyPractice {
    public static void main(String[] args) {
        //TODO
    //        Написать метод, который в блоке catch бросает ошибку и проверить,
        //        выполнится ли finally в таком случае

//        test1();

//        System.out.println(test2());
        test4();

    }

    public static void test1(){
        try {
            throw new RuntimeException();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("fin");
        }
    }


    public static String test2(){
        try {
            throw new NullPointerException();
        } catch (ArrayIndexOutOfBoundsException e){
            return e.getMessage();
        }
        finally {
            System.out.println("fin");
        }
    }

    static void test3() {
        int[] arr = new int[0];

        try {
            System.out.println(arr[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException();
        } finally {
            System.out.println("Tested");
        }
    }

    static String test4() {
        int[] arr = new int[0];

        try {
            System.out.println(arr[1]);
            return "test";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "test2";
        } finally {
            return "test3";
        }
    }

}
