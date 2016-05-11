package it.sevenbits.formatter.scanners;

import java.util.Scanner;

/**
 * Created by asus on 29.10.15.
 */
public class ConsoleCustomScanner implements IScanner {
    private int index = 0;
    private boolean hasNext = true;
    private Scanner scan;
    private char[] arr;

    public ConsoleCustomScanner() {
        scan = new Scanner(System.in);
        nextWordArray();
    }

    private void nextWordArray() {
        if (scan.hasNext()) {
            index = 0;
            arr = scan.nextLine().trim().toCharArray();
            if (arr.length == 0) {
                nextWordArray();
            }
        } else {
            hasNext = false;
        }
    }

    public boolean getHasNext() {
        return scan.hasNext();
    }

    public char getNextChar() {
        if (scan.hasNext()) {
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


