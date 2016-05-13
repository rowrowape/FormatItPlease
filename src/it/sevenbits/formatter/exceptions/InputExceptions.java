package it.sevenbits.formatter.exceptions;

/**
 * Input exception class
 * Objects of this class are created when an input error occurs
 */
public class InputExceptions extends Exception {
    /**
     * Input error constructor
     *
     * @param error
     */
    public InputExceptions(String error) {
        super(error);
    }
}
