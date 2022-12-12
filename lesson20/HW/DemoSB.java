package TRJavaHWs.lesson20.HW;

public class DemoSB {
    public static void main(String[] args) {
        CustomStringBuilder csb = new CustomStringBuilder();
        csb.append("hello");
        System.out.println(csb);
        csb.append("reeeeeeeeally big hellooooooooooooooo");
        System.out.println(csb);
        System.out.println(csb.charAt(5));
        System.out.println(csb.length());

        CustomStringBuilder fromString = new CustomStringBuilder("Check of the string");
        System.out.println(fromString);

        fromString.forEach(System.out::println);



    }
}
