package TRJavaHWs.lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpPractice2 {
    public static void main(String[] args) {

        String s1 = "telran.de";
        String s2 = "My telephone number is +10000000000";

        writePositionsString(s1);
        writePositionsString(s2);
    }

    static void writePositionsString(String s) {
        Pattern p = Pattern.compile("tel");

        int start = 0;
        int end = 0;
        Matcher mS = p.matcher(s);
         while (mS.find()){
        start = mS.start();
        end = mS.end();
         }

        //Вычислить start и end для первой и второй строк
        System.out.println("For the string " + s + "pattern found at positions from " + start + " to " + end);
    }
}
