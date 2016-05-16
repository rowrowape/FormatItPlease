package it.sevenbits.formatter.contexts;

/**
 * Created by ROW on 16.05.2016.
 */
public class Context {
    int openBrackets;
    char curChar;
    char prevChar;
    boolean newLine;
    String output;

    public Context() {
        openBrackets = 0;
        curChar = 0;
        prevChar = 0;
        newLine = false;
        String output = String.valueOf(curChar);
    }

    public int getOpenBrackets() {
        return openBrackets;
    }

    public void setOpenBrackets(int openBrackets) {
        this.openBrackets = openBrackets;
    }

    public char getCurChar() {
        return curChar;
    }

    public void setCurChar(char curChar) {
        this.curChar = curChar;
    }

    public char getPrevChar() {
        return prevChar;
    }

    public void setPrevChar(char prevChar) {
        this.prevChar = prevChar;
    }

    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

