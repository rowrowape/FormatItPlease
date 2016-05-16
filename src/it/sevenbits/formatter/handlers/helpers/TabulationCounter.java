package it.sevenbits.formatter.handlers.helpers;

import it.sevenbits.formatter.contexts.Context;

/**
 * Created by ROW on 17.05.2016.
 */
public class TabulationCounter {

    public String tab(Context context) {
        /**
         * function will male tabulation of code
         * @return String
         */
        for (int i = 0; i < context.getOpenBrackets(); i++) {
            context.setOutput(context.getOutput() + "    ");
        }
        return context.getOutput();
    }

}
