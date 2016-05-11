package it.sevenbits.formatter.writers;

import it.sevenbits.formatter.exceptions.OutputExceptions;


/**
 * Created by asus on 21.10.15.
 */
public interface IWriter {
    public void flush() throws OutputExceptions;

    public void append(String str) throws OutputExceptions;

    public void close() throws OutputExceptions;

    public void append(char chr) throws OutputExceptions;
}
