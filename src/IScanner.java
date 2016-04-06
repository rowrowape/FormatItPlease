import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public interface IScanner {
    public boolean getHasNext();
    public char getNextChar() throws IOException;
}
