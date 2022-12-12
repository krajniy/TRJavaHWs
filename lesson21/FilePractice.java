package TRJavaHWs.lesson21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilePractice {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/TRJavaHWs/lesson21/A");
        FileOutputStream fos = new FileOutputStream("src/TRJavaHWs/lesson21/B", true);
//        fis.transferTo(fos);
        fos.write(fis.readAllBytes());
        fis.close();
        fos.close();




    }


}
