import java.io.*;

class Counters {
    int count = 0;
    synchronized void increment() {
        count++;
    }
}

class MyThread2 extends Thread {
    Counters counter;
    MyThread2(Counters counter) {
        this.counter = counter;
    }
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 2L;
    int id;
    String name;
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class User implements Externalizable {
    int id;
    String pass;
    public User() {}
    User(int id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
    }
    public void readExternal(ObjectInput in) throws IOException {
        id = in.readInt();
    }
}

public class SerializationDemo{
    public static void main(String[] args) throws Exception {

        FileWriter fw = new FileWriter("text.txt");
        fw.write("Hello Java");
        fw.close();

        FileReader fr = new FileReader("text.txt");
        int c;
        while ((c = fr.read()) != -1) System.out.print((char)c);
        fr.close();

        FileOutputStream fos = new FileOutputStream("data.bin");
        fos.write(65);
        fos.close();

        FileInputStream fis = new FileInputStream("data.bin");
        System.out.println("\n" + fis.read());
        fis.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("buffer.txt"));
        bw.write("Buffered I/O");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("buffer.txt"));
        System.out.println(br.readLine());
        br.close();

        Employee e = new Employee(1,"Niteesh");
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("emp.ser"));
        oos1.writeObject(e);
        oos1.close();

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("emp.ser"));
        Employee e2 = (Employee)ois1.readObject();
        ois1.close();
        System.out.println(e2.name);

        User u = new User(10,"secret");
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("user.ser"));
        oos2.writeObject(u);
        oos2.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("user.ser"));
        User u2 = (User)ois2.readObject();
        ois2.close();
        System.out.println(u2.id);

        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
