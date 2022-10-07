package TRJavaHWs.lesson4;

import java.util.Scanner;

public class HowMany {
    int count = 0;

    public int getCount() {
        return count;
    }

    public void scan(){
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).trim().equals("")){
            String[] words = line.split(" ");
            count+= words.length;
        }
        if ((scanner.nextLine()).trim().equals("")){
            System.out.println("That's all");
        }
        System.out.println("Number of words: " + getCount());
    }

}
