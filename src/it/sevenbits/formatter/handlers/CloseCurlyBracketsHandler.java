package it.sevenbits.formatter.handlers;

import it.sevenbits.formatter.contexts.Context;
import it.sevenbits.formatter.handlers.helpers.TabulationCounter;

/**
 * Created by ROW on 17.05.2016.
 */
public class CloseCurlyBracketsHandler implements IHandler {
    TabulationCounter tabulation = new TabulationCounter();

    public void handle(Context context) {
        /**
         * function will format close brackets in code
         * enter line breaks
         * @param curChar incoming arguments
         */
        if (context.getCurChar() == '}') {
            context.setOpenBrackets(context.getOpenBrackets() - 1);
            context.setOutput(context.getOutput() + '\n');
            if (context.isNewLine()) {
                context.setOutput(tabulation.tab(context));
            }
            context.setNewLine(true);
        }

    }
}
