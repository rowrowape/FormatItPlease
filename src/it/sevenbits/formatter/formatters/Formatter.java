package it.sevenbits.formatter.formatters;

import it.sevenbits.formatter.exceptions.InputExceptions;
import it.sevenbits.formatter.exceptions.OutputExceptions;
import it.sevenbits.formatter.scanners.IScanner;
import it.sevenbits.formatter.writers.IWriter;

import java.io.IOException;

/**
 * Class, that implements method of format code
 */
public class Formatter implements IFormatter {
    IScanner scanner;
    IWriter writer;

    public Formatter(IScanner argScanner, IWriter argWriter) {
        /**
         * public constructor with scanner and writer
         */
        this.scanner = argScanner;
        this.writer = argWriter;
    }


    int openBrackets = 0;
    char curChar = 0;
    char prevChar = 0;
    boolean isNewLine = false;
    String output = String.valueOf(curChar);


    public void format() throws InputExceptions, OutputExceptions {
        /**
         *call the handler function and format the code
         * @throws InputExceptions
         * @throws OutputExceptions
         */
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

            openBracketsHandler(curChar, prevChar);
            closeBracketsHandler(curChar);
            semicolonHandler(curChar);
            spaceHandler(prevChar, curChar);
            tabulationHandler();
            writeOutput();
        }

        writer.close();
    }

    private String tab(int openBrackets) {
        /**
         * function will male tabulation of code
         * @return String
         */
        for (int i = 0; i < openBrackets; i++) {
            output = output + "    ";
        }
        return output;
    }

    private void openBracketsHandler(char curChar, char prevChar) {
        /**
         * function will format open brackets in code
         * enter spaces and line breaks
         * @param curChar incoming arguments
         * @param prevChar incoming arguments
         */

        if (curChar == '{') {
            output = output + '\n';
            if (prevChar != ' ') {
                output = ' ' + output;
            }
            if (isNewLine) {
                output = tab(openBrackets);
            }
            openBrackets++;
            isNewLine = true;
        }
    }

    private void closeBracketsHandler(char curChar) {
        /**
         * function will format close brackets in code
         * enter line breaks
         * @param curChar incoming arguments
         */
        if (curChar == '}') {
            openBrackets--;
            output = output + '\n';
            if (isNewLine) {
                output = tab(openBrackets);
            }
            isNewLine = true;
        }

    }

    private void semicolonHandler(char curChar) {
        /**
         * function will format semicolons in code
         * enter line breaks
         * @param curChar incoming arguments
         */
        if (curChar == ';') {
            output = output + '\n';
            isNewLine = true;
        }

    }

    private void spaceHandler(char prevChar, char curChar) {
        /**
         * function will format spaces in code
         * delete excess spaces
         * @param curChar incoming arguments
         */
        if (curChar == ' ') {
            if (prevChar == ' ') {
                if (prevChar == ' ') {
                    output = "";
                }
            }
        }

    }

    private void tabulationHandler() {
        /**
         * function will format code
         * entry tabulations
         * delete excess spaces
         */
        if (isNewLine) {
            output = tab(openBrackets);
        }
        isNewLine = false;

    }


    private void writeOutput() throws OutputExceptions {
        /**
         *write the output after handlers work
         * @throws OutputExceptions
         */
        writer.append(output);
        output = "";
        writer.flush();

    }
}