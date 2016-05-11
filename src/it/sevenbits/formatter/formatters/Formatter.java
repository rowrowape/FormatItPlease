package it.sevenbits.formatter.formatters;

import it.sevenbits.formatter.exceptions.InputExceptions;
import it.sevenbits.formatter.exceptions.OutputExceptions;
import it.sevenbits.formatter.scanners.IScanner;
import it.sevenbits.formatter.writers.IWriter;

import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public class Formatter implements IFormatter {
    IScanner scanner;
    IWriter writer;

    public Formatter(IScanner argScanner, IWriter argWriter) {
        this.scanner = argScanner;
        this.writer = argWriter;
    }

    private String tab(int openBrackets) {
        for (int i = 0; i < openBrackets; i++) {
            output = output + "    ";
        }
        return output;
    }

    int openBrackets = 0;
    char curChar = 0;
    char prevChar = 0;
    boolean isNewLine = false;
    String output = String.valueOf(curChar);

    public void format() throws InputExceptions, OutputExceptions {

        if (scanner.getHasNext()) {
            curChar = scanner.getNextChar();
            writer.append(curChar);
        }

        while (scanner.getHasNext()) {
            prevChar = curChar;
            curChar = scanner.getNextChar();
            output = String.valueOf(curChar);
            if (curChar == ' ' && isNewLine) {
                continue;
            }
            if (curChar == '\n') {
                continue;
            }

            openBracketsHandler(curChar);

            closeBracketsHandler(curChar);
            semicolonHandler(curChar);
            spaceHandler(prevChar, curChar);
            tabulationHandler();
            writeOutput();
        }

        writer.close();
    }


    private void openBracketsHandler(char curChar) {
        if (curChar == '{') {
            output = ' ' + output + '\n';
            if (isNewLine) {
                output = tab(openBrackets);
            }
            openBrackets++;
            isNewLine = true;
        }
    }

    private void closeBracketsHandler(char curChar) {
        if (curChar == '}') {
            openBrackets--;
            output = '\n' + output;
            if (isNewLine) {
                output = tab(openBrackets);
            }
            isNewLine = true;
        }

    }

    private void semicolonHandler(char curChar) {
        if (curChar == ';') {
            output = output + '\n';
            isNewLine = true;
        }

    }

    private void spaceHandler(char prevChar, char curChar) {
        if (curChar == ' ') {
            if (prevChar == ' ') {
                if (prevChar == ' ') {
                    output = "";
                }
            }
        }

    }

    private void tabulationHandler() {
        if (isNewLine) {
            output = tab(openBrackets);
        }
        isNewLine = false;

    }

    private void writeOutput() throws OutputExceptions {
        writer.append(output);
        output = "";
        writer.flush();

    }
}