package TRJavaHWs.lesson21;

import java.util.regex.Pattern;

public class RegExpPractice {

    public static void main(String[] args) {
        String s = "www.telran.de";
        String s1 = "https://www.google.com";

        Pattern p = Pattern.compile("(https?://)?(www\\.)?.+\\.(com|de)");

        System.out.println(p.matcher(s).matches());         // true
        System.out.println(p.matcher(s1).matches());        // true

    }
}
