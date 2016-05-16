package it.sevenbits.formatter.formatters;

import it.sevenbits.formatter.contexts.Context;
import it.sevenbits.formatter.exceptions.InputExceptions;
import it.sevenbits.formatter.exceptions.OutputExceptions;
import it.sevenbits.formatter.handlers.IHandler;
import it.sevenbits.formatter.scanners.IScanner;
import it.sevenbits.formatter.writers.IWriter;

import java.util.List;

/**
 * Class, that implements method of format code
 */
public class Formatter implements IFormatter {
    private IScanner scanner;
    private IWriter writer;
    private List <IHandler> handlers;
    private Context context = new Context();

    public Formatter(IScanner curScanner, IWriter curWriter, List <IHandler> handlers) {
        /**
         * public constructor with scanner, writer and handlers list
         *
         * @param curWriter
         * @param curScanner
         * @param handlers
         */
        this.handlers = handlers;
        this.scanner = curScanner;
        this.writer = curWriter;
    }


    public void format() throws InputExceptions, OutputExceptions {
        /**
         *call the handler function and format the code
         * @throws InputExceptions
         * @throws OutputExceptions
         */
        if (scanner.getHasNext()) {
            context.setCurChar(scanner.getNextChar());
            writer.append(context.getCurChar());
        }

        while (scanner.getHasNext()) {
            context.setCurChar(context.getCurChar());
            context.setCurChar(scanner.getNextChar());
            context.setOutput(String.valueOf(context.getCurChar()));
            if (context.getCurChar() == ' ' && context.isNewLine()) {
                continue;
            }
            if (context.getCurChar() == '\n') {
                continue;
            }
            for(IHandler handler:handlers) {
                handler.handle(context);
            }
            writer.append(context.getOutput());
            context.setOutput("");
        }

        writer.close();
    }









}