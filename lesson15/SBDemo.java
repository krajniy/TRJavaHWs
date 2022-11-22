package TRJavaHWs.lesson15;

public class SBDemo {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("H").
                append("e").
                append("l").
                append("p");


        System.out.println(sb.toString());
        System.out.println(sb.reverse());

    }
}
