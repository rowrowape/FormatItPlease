package it.sevenbits.formatter.handlers;

import it.sevenbits.formatter.contexts.Context;
import it.sevenbits.formatter.handlers.helpers.TabulationCounter;

/**
 *
 */
public class OpenCurlyBracketsHandler implements IHandler {

    TabulationCounter tabulation = new TabulationCounter();

    public void handle(Context context) {
            /**
             * function will format open brackets in code
             * enter spaces and line breaks
             * @param context incoming argument
             */

            if (context.getCurChar() == '{') {
                context.setOutput(context.getOutput() + '\n');
                if (context.getPrevChar() != ' ') {
                    context.setOutput(' ' + context.getOutput());
                }
            if (context.isNewLine()) {
                context.setOutput(tabulation.tab(context));
            }
            context.setOpenBrackets(context.getOpenBrackets() + 1);
            context.setNewLine(true);
        }
    }
}
