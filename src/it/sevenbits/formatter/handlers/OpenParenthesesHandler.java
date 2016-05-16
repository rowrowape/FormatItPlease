package it.sevenbits.formatter.handlers;

import it.sevenbits.formatter.contexts.Context;

/**
 * Created by ROW on 17.05.2016.
 */
public class OpenParenthesesHandler implements IHandler{
    public void handle(Context context) {
        /**
         * function will format open brackets in code
         * enter spaces and line breaks
         * @param context incoming arguments
         */
        if (context.getCurChar() == '(') {
            if (context.getPrevChar() != ' ') {
                context.setOutput(' ' + context.getOutput());
            }
        }
    }
}
