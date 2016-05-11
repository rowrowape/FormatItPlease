package it.sevenbits.formatter.writers;

import it.sevenbits.formatter.exceptions.OutputExceptions;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public class CustomWriter implements IWriter {

    FileWriter writer;
    public CustomWriter(String filePath) throws OutputExceptions {
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }

    }
    @Override
    public void flush() throws OutputExceptions {
        try{
        writer.flush();
        } catch (IOException e) {
        throw new OutputExceptions(e.getMessage());
        }
    }

    @Override
    public void append(String str) throws OutputExceptions {

        try{
        writer.append(str);
    } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }

    @Override
    public void close() throws OutputExceptions {
        try{
        writer.close();
    } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }

    @Override
    public void append(char chr) throws OutputExceptions {
        try{
        writer.append(chr);
    } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }
}
