import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IScanner fscan = new CustomScanner("input.txt");
        IWriter wrt = new CustomWriter("output.txt");
        IFormatter formatter = new Formatter();
        formatter.format(fscan, wrt);
    }
}


