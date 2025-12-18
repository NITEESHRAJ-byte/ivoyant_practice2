//BufferedReader and BufferedWriter for efficient I/O

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class BufferedDemo {
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter("buffer.txt"));
        bw.write("Buffered writing");
        bw.newLine();
        bw.write("Fast I/O");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("buffer.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}