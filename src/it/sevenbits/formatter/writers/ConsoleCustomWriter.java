package it.sevenbits.formatter.writers;

import it.sevenbits.formatter.exceptions.OutputExceptions;

import java.io.PrintWriter;

/**
 * Writer for console
 * TODO
 */

public class ConsoleCustomWriter implements IWriter {

    public void append(String str) throws OutputExceptions {
        System.out.print(str);
    }


    public void close() throws OutputExceptions {
    }


    public void append(char chr) throws OutputExceptions {
        System.out.print(chr);
    }
}