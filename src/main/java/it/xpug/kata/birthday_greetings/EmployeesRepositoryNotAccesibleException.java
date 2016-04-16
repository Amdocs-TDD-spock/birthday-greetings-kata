package it.xpug.kata.birthday_greetings;

import java.io.FileNotFoundException;

/**
 * The Employees storage/source is not available.
 */
public class EmployeesRepositoryNotAccesibleException extends RuntimeException {
    public EmployeesRepositoryNotAccesibleException(Throwable e) {
        super(e);
    }
}
