package it.sevenbits.formatter.formatters;

import it.sevenbits.formatter.exceptions.InputExceptions;
import it.sevenbits.formatter.exceptions.OutputExceptions;

import java.io.IOException;

/**
 * Interface class for formatter class
 */
public interface IFormatter {
    /**
     * declaration of formatter methods
     *
     * @throws InputExceptions
     * @throws OutputExceptions
     */
    public void format() throws InputExceptions, OutputExceptions;
}
