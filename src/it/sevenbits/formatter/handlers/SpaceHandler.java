package it.sevenbits.formatter.handlers;

import it.sevenbits.formatter.contexts.Context;

/**
 * Created by ROW on 17.05.2016.
 */
public class SpaceHandler implements IHandler {
    public void handle(Context context) {
        /**
         * function will format spaces in code
         * delete excess spaces
         * @param context incoming argument
         */
        if (context.getCurChar() == ' ') {
            if (context.getPrevChar() == ' ') {
                context.setOutput("");
            }
        }

    }
}
