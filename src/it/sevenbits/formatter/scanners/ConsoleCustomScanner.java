package it.sevenbits.formatter.scanners;

import java.util.Scanner;

/**
 * Class, that implements methods of scanner writer
 */

public class ConsoleCustomScanner implements IScanner {
    /**
     * create file scanner
     * declaration of constructor
     * and support methods of reading symbol
     * from console
     * reading of symbols ends when user enter "ctrl+d"
     * public CustomScanner(String filePath)
     * private void nextWordArray()
     * public boolean getHasNext()
     * public char getNextChar()
     */

    private int index = 0;
    private boolean hasNext = true;
    private Scanner scan;
    private char[] arr;

    public ConsoleCustomScanner() {
        /**
         * public constructor of class
         */
        scan = new Scanner(System.in);
        nextWordArray();
    }

    private void nextWordArray() {
        /**
         * reads a string and turns it into an array
         * if string was empty method should read next string
         * public CustomScanner(String filePath) throws InputExceptions
         * private void nextWordArray() throws InputExceptions
         * public boolean getHasNext()
         * public char getNextChar() throws InputExceptions
         */
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
        /**
         * getter for hasNext
         * @return boolean
         */
        return scan.hasNext();
    }

    public char getNextChar() {
        /**
         * read a symbol
         * @return char
         */
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


