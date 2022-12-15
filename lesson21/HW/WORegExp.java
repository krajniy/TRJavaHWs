package TRJavaHWs.lesson21.HW;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WORegExp {
    public static void main(String[] args) {

        System.out.println(setThousandSeparator(2000000));

    }

    public static String setThousandSeparator(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        StringBuilder reversed = new StringBuilder(s).reverse();

        if (s.length() < 4) {
            return s;
        }
        int count = 0;
        for (int i = 0; i < reversed.length()-3; i+=3) {
            sb.append(reversed.substring(i, i+3)).append(",");
            count++;
        }

        int dif = s.length() - (sb.length()-count);
        sb.append(reversed.substring(reversed.length()-dif));

        return sb.reverse().toString();

    }
}
