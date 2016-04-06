import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public interface IFormatter {
    public void format(IScanner scan, IWriter wrt) throws IOException;


}
