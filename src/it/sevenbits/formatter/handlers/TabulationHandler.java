package it.sevenbits.formatter.handlers;

import it.sevenbits.formatter.contexts.Context;
import it.sevenbits.formatter.handlers.helpers.TabulationCounter;

/**
 * Created by ROW on 17.05.2016.
 */
public class TabulationHandler implements IHandler {
    TabulationCounter tabulation = new TabulationCounter();

    public void handle(Context context) {
        /**
         * function will format code
         * entry tabulations
         * delete excess spaces
         */
        if (context.isNewLine()) {
            context.setOutput(tabulation.tab(context));
        }
        context.setNewLine(false);

    }
}
