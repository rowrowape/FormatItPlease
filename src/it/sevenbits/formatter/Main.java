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
import org.apache.log4j.Logger;

public class Main {
    /**
     * Entry point
     * Create scanner & writer, call format function with arguments
     */
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        /**
         * main void
         * Create scanner & writer, call format function with arguments
         * args[0] should contain the name of file for input or args[0] = console
         * if application should read data from the console
         * args[1] should contain the name of file for output or args[0] = console
         * if application should write data to the console
         */
        IScanner scanner = null;
        try {
            if (args[0].equals("console")) {
                scanner = new ConsoleCustomScanner();
            } else {

                scanner = new CustomScanner(args[0]);
            }
        } catch (InputExceptions e) {
            logger.info("Creating scanner error");
        }

        IWriter writer = null;
        try {
            if (args[1].equals("console")) {
            } else {
                writer = new CustomWriter(args[1]);
            }
        } catch (OutputExceptions e) {
            logger.info("Creating writer error");
        }

        IFormatter formatter = new Formatter(scanner, writer);
        try {
            formatter.format();
        } catch (InputExceptions e) {
            logger.info("Input exception error in formatter");
        } catch (OutputExceptions e) {
            logger.info("Output exception error in formatter");
        }
    }
}



