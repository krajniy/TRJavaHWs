package TRJavaHWs.lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpPractice2 {
    public static void main(String[] args) {

        String s1 = "telran.de";
        String s2 = "My telephone number is +10000000000";
        String s3 = "TELEGRAM";

        writePositionsString(s1);
        writePositionsString(s2);
        writePositionsString(s3);
    }

    static void writePositionsString(String s) {
        Pattern p = Pattern.compile("tel", Pattern.CASE_INSENSITIVE);

        Matcher mS = p.matcher(s);
         while (mS.find()){
             System.out.println("For the string " + s + "pattern found at positions from " + mS.start() + " to " + (mS.end()-1));

         }

    }
}
