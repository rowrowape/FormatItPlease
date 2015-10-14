import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static String tab(int openBrackets, String output) {
        for (int i = 0; i < openBrackets; i++) {
            output = "    " + output;
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        int openBrackets = 0;
        CustomScanner fscan = new CustomScanner("input.txt");
        FileWriter wrt = new FileWriter("output.txt");
        char curChar = 0;
        char prevChar = 0;
        boolean isNewLine = false;
        if (fscan.getHasNext()) {
            curChar = fscan.getNextChar();
            wrt.append(curChar);
        }
        while (fscan.getHasNext()) {
            prevChar = curChar;
            curChar = fscan.getNextChar();
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


