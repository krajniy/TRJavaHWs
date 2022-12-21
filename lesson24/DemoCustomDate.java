package TRJavaHWs.lesson24;

public class DemoCustomDate {
    public static void main(String[] args) {
        CustomDateTime dateTime = new CustomDateTime(System.currentTimeMillis());
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHour());
        System.out.println(dateTime.getMinute());
        System.out.println(dateTime.getSeconds());

        System.out.println(dateTime);
    }
}
