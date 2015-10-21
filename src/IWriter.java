import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public interface IWriter {
    public void flush() throws IOException;
    public  void append(String str) throws IOException;
    public void close() throws IOException;
    public void append (char chr) throws IOException;
}
