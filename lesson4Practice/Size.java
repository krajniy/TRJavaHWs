package TRJavaHWs.lesson4Practice;

public enum Size {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRALARGE;

    public void orderPizza(Size size){
        switch (size){
            case LARGE -> System.out.println("You ordered large pizza");
            case SMALL -> System.out.println("You ordered small pizza");
            case MEDIUM -> System.out.println("You ordered medium pizza");
            case EXTRALARGE -> System.out.println("You ordered extra large pizza");
        }
    }

    public static void main(String[] args) {
        System.out.println(Size.SMALL);
        System.out.println(Size.LARGE);
        for (Size size : Size.values()){
            Size newSize = size;
            System.out.println(newSize);


        }


    }
}
