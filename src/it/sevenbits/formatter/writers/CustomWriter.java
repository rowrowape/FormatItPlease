package it.sevenbits.formatter.writers;

import it.sevenbits.formatter.exceptions.OutputExceptions;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class, that implements methods of file writer
 */
public class CustomWriter implements IWriter {
    /**
     * create file writer
     * redefining the standard methods:
     * * public void flush() throws OutputExceptions
     * public void append(String str) throws OutputExceptions
     * public void close()
     * public void append(char chr) throws OutputExceptions
     */

    FileWriter writer;

    public CustomWriter(String filePath) throws OutputExceptions {
        /**
         * public constructor of class
         * @throws OutputExceptions
         * @param filePath incoming arguments contain name of file
         */
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }

    }

    @Override
    public void flush() throws OutputExceptions {
        /**
         * redefining the standard method flush of FleWriter
         * @throws OutputExceptions
         */
        try {
            writer.flush();
        } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }

    @Override
    public void append(String str) throws OutputExceptions {
        /**
         * redefining the standard method append of FleWriter
         * @throws OutputExceptions
         */
        try {
            writer.append(str);
        } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }

    @Override
    public void close() throws OutputExceptions {
        /**
         * redefining the standard method close of FleWriter
         * @throws OutputExceptions
         */
        try {
            writer.close();
        } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }

    @Override
    public void append(char chr) throws OutputExceptions {
        /**
         * redefining the standard method append of FleWriter
         * @param chr incoming arguments
         * @throws OutputExceptions
         */
        try {
            writer.append(chr);
        } catch (IOException e) {
            throw new OutputExceptions(e.getMessage());
        }
    }
}
