import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public class CustomWriter implements IWriter {

    FileWriter wrt;
    CustomWriter (String filePath) throws IOException {
        wrt = new FileWriter(filePath);


    }
    @Override
    public void flush() throws IOException {
        wrt.flush();
    }

    @Override
    public void append(String str) throws IOException {
        wrt.append(str);
    }

    @Override
    public void close() throws IOException {
        wrt.close();
    }

    @Override
    public void append(char chr) throws IOException {
        wrt.append(chr);
    }
}
