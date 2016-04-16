package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Employee Repository - takes the responsability of giving the list of employees from the storage layer (file, database, internet, etc).
 */
public interface EmployeeRepository {
    Stream<Employee> loadEmployees() throws EmployeesRepositoryNotAccesibleException;
}
