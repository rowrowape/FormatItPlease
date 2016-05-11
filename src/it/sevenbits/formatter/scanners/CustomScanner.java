package it.sevenbits.formatter.scanners;

import it.sevenbits.formatter.exceptions.InputExceptions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by asus on 14.10.15.
 */
public class CustomScanner implements IScanner {
    private int index = 0;
    private boolean hasNext = true;
    private Scanner scan;
    private char[] arr;

    public CustomScanner(String filePath) throws InputExceptions {
        File file = new File(filePath);
        try {
            scan = new Scanner(file);
            nextWordArray();
        } catch (IOException e) {
            throw new InputExceptions(e.getMessage());
        }
    }

    private void nextWordArray() throws InputExceptions {
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

    public char getNextChar() throws InputExceptions {
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
