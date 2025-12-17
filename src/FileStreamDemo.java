//Input and output of Binary Data

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStreamDemo {
    public static void main(String[] args) throws Exception {

        // Writing binary data
        FileOutputStream fos = new FileOutputStream("data.bin");
        fos.write(65);
        fos.close();

        // Reading binary data
        FileInputStream fis = new FileInputStream("data.bin");
        System.out.println(fis.read());
        fis.close();
    }
}