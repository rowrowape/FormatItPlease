import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public class Formatter implements IFormatter {

    private static String tab(int openBrackets, String output) {
        for (int i = 0; i < openBrackets; i++) {
            output = "    " + output;
        }
        return output;
    }

    public void format(IScanner scan, IWriter wrt) throws IOException {
        int openBrackets = 0;
        char curChar = 0;
        char prevChar = 0;
        boolean isNewLine = false;
        if (scan.getHasNext()) {
            curChar = scan.getNextChar();
            wrt.append(curChar);
        }
        while (scan.getHasNext()) {
            prevChar = curChar;
            curChar = scan.getNextChar();
            String output = String.valueOf(curChar);
            switch (curChar) {
                case '{':
                    output = output + "\n";
                    if (isNewLine) {
                        output = tab(openBrackets, output);
                    }
                    openBrackets++;
                    isNewLine = true;
                    break;
                case '}':
                    openBrackets--;
                    output = output + "\n";
                    if (isNewLine) {
                        output = tab(openBrackets, output);
                    }
                    isNewLine = true;
                    break;
                case ';':
                    output = output + "\n";
                    isNewLine = true;
                    break;
                case ' ' :
                    if (prevChar == ' ') {
                        output = "";
                        break;
                    }
                    //case '+' : if (prevChar = ' ')
                default:
                    if (isNewLine) {
                        output = tab(openBrackets, output);
                    }
                    isNewLine = false;
                    break;
            }
            wrt.append(output);
            wrt.flush();
        }
        wrt.close();
    }
}
