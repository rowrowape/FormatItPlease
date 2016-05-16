package it.sevenbits.formatter.exceptions;

/**
 * Input exception class
 * Objects of this class are created when an output error occurs
 */
public class OutputExceptions extends Exception {
    /**
     * Output error constructor
     *
     * @param error
     */
    public OutputExceptions(String error) {

        super(error);
    }
}
