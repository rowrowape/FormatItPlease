package it.sevenbits.formatter.handlers;

import it.sevenbits.formatter.contexts.Context;

/**
 * Created by ROW on 17.05.2016.
 */
public class SemicolonHandler implements IHandler {
    public void handle(Context context) {
        /**
         * function will format semicolons in code
         * enter line breaks
         * @param context incoming argument
         */
        if (context.getCurChar() == ';') {
            context.setOutput(context.getOutput() + '\n');
            context.setNewLine(true);
        }

    }
}
