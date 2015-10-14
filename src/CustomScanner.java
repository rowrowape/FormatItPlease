import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by asus on 14.10.15.
 */
public class CustomScanner {
    private int index = 0;
    private boolean hasNext = true;
    private Scanner scan;
    private char[] arr;

    CustomScanner(String filePath) throws IOException {
        File file = new File(filePath);
        scan = new Scanner(file);
        nextWordArray();
    }

    private void nextWordArray() throws IOException {
        if (scan.hasNext()) {
            index = 0;
            arr = scan.nextLine().trim().toCharArray();
            if (arr.length==0){
                nextWordArray();
            }
        } else {
            hasNext = false;
        }
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public char getNextChar() throws IOException {
        if (hasNext) {
            char buf = arr[index];
            index++;
            if (index >= arr.length) {
                nextWordArray();
            }
            return buf;
        }
        return (char) 0;
    }
}