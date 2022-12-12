package TRJavaHWs.lesson21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePractice {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/TRJavaHWs/lesson21/A");
        FileOutputStream fos = new FileOutputStream("src/TRJavaHWs/lesson21/B", true);
        fis.transferTo(fos);




    }


}
