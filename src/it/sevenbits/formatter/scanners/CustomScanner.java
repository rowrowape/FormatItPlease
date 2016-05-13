package it.sevenbits.formatter.scanners;

import it.sevenbits.formatter.exceptions.InputExceptions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class, that implements methods of scanner writer
 */

public class CustomScanner implements IScanner {

    /**
     * create file scanner
     * declaration of constructor
     * and support methods of reading symbol from file
     * public CustomScanner(String filePath) throws InputExceptions
     * private void nextWordArray() throws InputExceptions
     * public boolean getHasNext()
     * public char getNextChar() throws InputExceptions
     */

    private int index = 0;
    private boolean hasNext = true;
    private Scanner scan;
    private char[] arr;

    public CustomScanner(String filePath) throws InputExceptions {
        /**
         * public constructor of class
         * @throws InputExceptions
         * @param filePath incoming arguments contain name of file
         */
        File file = new File(filePath);
        try {
            scan = new Scanner(file);
            nextWordArray();
        } catch (IOException e) {
            throw new InputExceptions(e.getMessage());
        }
    }

    private void nextWordArray() throws InputExceptions {
        /**
         * reads a string and turns it into an array
         * if string was empty method should read next string
         * @throws InputExceptions
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
        return hasNext;
    }

    public char getNextChar() throws InputExceptions {
        /**
         * read a symbol
         * @throws InputExceptions
         * @return char
         */
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
