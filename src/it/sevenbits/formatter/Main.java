package it.sevenbits.formatter;

import it.sevenbits.formatter.exceptions.InputExceptions;
import it.sevenbits.formatter.exceptions.OutputExceptions;
import it.sevenbits.formatter.formatters.Formatter;
import it.sevenbits.formatter.formatters.IFormatter;
import it.sevenbits.formatter.scanners.ConsoleCustomScanner;
import it.sevenbits.formatter.scanners.CustomScanner;
import it.sevenbits.formatter.scanners.IScanner;
import it.sevenbits.formatter.writers.CustomWriter;
import it.sevenbits.formatter.writers.IWriter;


public class Main {

    public static void main(String[] args) {
        IScanner scanner = null;
        if (args[0].equals("console")) {
            scanner = new ConsoleCustomScanner();
        } else {
            try {
                scanner = new CustomScanner(args[0]);
            } catch (InputExceptions e) {
                //TODO:logger
            }
        }

        IWriter writer = null;
        if (args[0].equals("console")) {
        } else {
            try {
                writer = new CustomWriter(args[1]);
            } catch (OutputExceptions e) {
                //TODO:logger
            }
        }

        IFormatter formatter = new Formatter(scanner, writer);
        try {
            formatter.format();
        } catch (InputExceptions e) {
            //TODO:logger
        } catch (OutputExceptions e) {
            //TODO:logger
        }
    }
}



