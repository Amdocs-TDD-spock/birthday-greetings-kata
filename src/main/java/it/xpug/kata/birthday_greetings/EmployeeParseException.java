package it.xpug.kata.birthday_greetings;

import java.text.ParseException;

/**
 * Created by dnmaras on 4/16/16.
 */
public class EmployeeParseException extends BirthdayServiceException {
    public EmployeeParseException(Throwable e) {
        super(e);
    }
}
