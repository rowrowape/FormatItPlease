package it.sevenbits.formatter.writers;

import it.sevenbits.formatter.exceptions.OutputExceptions;

/**
 * Interface class for writers
 */
public interface IWriter {
    /**
     * declaration of writer methods
     *
     * @throws OutputExceptions
     */
    public void append(String str) throws OutputExceptions;

    public void close() throws OutputExceptions;

    public void append(char chr) throws OutputExceptions;
}
