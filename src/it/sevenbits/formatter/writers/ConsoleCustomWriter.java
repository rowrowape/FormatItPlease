package it.sevenbits.formatter.writers;

import it.sevenbits.formatter.exceptions.OutputExceptions;

import java.io.PrintWriter;

/**
 * Created by ROW on 12.05.2016.
 */
public class ConsoleCustomWriter implements IWriter {

    ConsoleCustomWriter(){

    }

    public void flush() throws OutputExceptions {
        return;
    }

    public void append(String str) throws OutputExceptions {
        return;
    }


    public void close() throws OutputExceptions {
        return;
    }


    public void append(char chr) throws OutputExceptions {
        return;
    }
}