//Reading and writing Text files

import java.io.FileWriter;
import java.io.FileReader;

public class FileReaderWriterDemo {
    public static void main(String[] args) throws Exception {

        // Writing text
        FileWriter fw = new FileWriter("text.txt");
        fw.write("Hello Java File I/O");
        fw.close();

        // Reading text
        FileReader fr = new FileReader("text.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}