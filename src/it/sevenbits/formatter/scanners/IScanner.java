package it.sevenbits.formatter.scanners;

import it.sevenbits.formatter.exceptions.InputExceptions;

import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public interface IScanner {
    public boolean getHasNext();

    public char getNextChar() throws InputExceptions;
}
