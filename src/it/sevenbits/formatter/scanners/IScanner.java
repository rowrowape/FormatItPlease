package it.sevenbits.formatter.scanners;

import it.sevenbits.formatter.exceptions.InputExceptions;

/**
 * Interface class for scanners
 */
public interface IScanner {
    /**
     * declaration of scanner methods
     *
     * @return
     * @throws InputExceptions
     */
    public boolean getHasNext();

    public char getNextChar() throws InputExceptions;
}
