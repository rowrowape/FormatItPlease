package it.sevenbits.formatter.formatters;

import it.sevenbits.formatter.exceptions.InputExceptions;
import it.sevenbits.formatter.exceptions.OutputExceptions;

import java.io.IOException;

/**
 * Created by asus on 21.10.15.
 */
public interface IFormatter {
    public void format() throws InputExceptions, OutputExceptions;


}
