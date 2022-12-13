package TRJavaHWs.lesson21.HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpsHW {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // Write a Java program to check whether a string contains only a certain set of characters
        //            (in this case a-z, A-Z and 0-9).
        String certain = bf.readLine();
        System.out.println(certainSetOfCharacters(certain));


        //Write a Java program that matches a string that has a 'p' followed by anything, ending in 'q'.
        //        aaaapgdgdsq -> true
        //        aaaapsfhsfh -> false

        String endQ = bf.readLine();
        System.out.println(endingQ(endQ));


        //Write a Java program to match a string that contains only upper and lowercase letters,
        //        numbers, and underscores.
        //        AgddHbnfFH_GDsgsg1dsgSdg3 -> true
        //        KGHSDG8jm3!!@# -> false

        String upLowLetNumsUnds = bf.readLine();
        System.out.println(upperAndLowerLettersNumsUnderscores(upLowLetNumsUnds));


        //Write a Java program that takes a number and set thousands separator in that number.
        //        2000 -> 2,000

        String thSep = bf.readLine();
        System.out.println(setThousandSeparator(thSep));


        //Write a Java program to validate a given phone number.
        //        Телефонные номера начинаются с + и имеют 1-3 символа кода страны, затем идет 3 символа кода оператора и
        //        7 символов самого номера
        String phone = "+1 333 7777777";
        System.out.println(phoneValidation(phone));


        //Write a Java program to check if a given string is a Mathematical Expression or not.
        //        Строка может содержать в себе буквы и цифры, разделенные символами +, -, *, /
        String mathExp = "-55 * 55 / 11 +109";
        String notMathExp = " * 55 a 55";

        System.out.println(isMathExp(mathExp));
        System.out.println(isMathExp(notMathExp));



        //Write a Java program to insert a dash (-) between an upper case letter and a lower case letter in a given string.
        //        AbCd -> A-bC-d
        String woDash = "AbCd";
        System.out.println(insertDash(woDash));





    }

    public static boolean certainSetOfCharacters(String s) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]+$");

        return p.matcher(s).matches();
    }

    public static boolean endingQ(String s) {
        Pattern p = Pattern.compile("\\w+q$");

        return p.matcher(s).matches();
    }

    public static boolean upperAndLowerLettersNumsUnderscores(String s) {
        Pattern p = Pattern.compile("(\\w|_)+", Pattern.CASE_INSENSITIVE);

        return p.matcher(s).matches();
    }

    public static String setThousandSeparator(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder reversed = new StringBuilder(s).reverse();

        Pattern p = Pattern.compile("(\\d{3})");
        Matcher m = p.matcher(reversed);

        if (s.length() < 4) {
            return s;
        }
        int count = 0;
        while (m.find() && sb.length() - count < s.length()-3){
            sb.append(m.group()).append(",");
            count++;
        }
        int dif = s.length() - (sb.length()-count);
        sb.append(reversed.substring(reversed.length()-dif));

        return sb.reverse().toString();

    }


    public static boolean phoneValidation(String s){

        Pattern p = Pattern.compile("^\\+\\d{1,3}\\s?\\d{3}\\s?\\d{7}$");
        Matcher m = p.matcher(s);

        return m.matches();

    }

    public static boolean isMathExp(String s){

        Pattern p = Pattern.compile("(\\-?\\w+\\s?[\\*\\/\\+\\-]\\s?\\w+)+");
        Matcher m = p.matcher(s);

        return m.matches();

    }

    public static String insertDash(String s){


        return s.replaceAll("(?<=[A-Z])(?=[a-z])", "-");

    }

}
