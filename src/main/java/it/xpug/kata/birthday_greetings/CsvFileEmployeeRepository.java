package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.stream.Stream;

/**
 * Employee Repository implementation which reads from a file.
 */
public class CsvFileEmployeeRepository implements EmployeeRepository {
    private Path file;

    public CsvFileEmployeeRepository(File fileName) {
        this.file = Paths.get(fileName.toURI());
    }

    public Stream<Employee> loadEmployees() {
        try {
            return Files.lines(file).skip(1)
                    .map(line -> getEmployee(line));
        } catch (IOException e) {
            throw new EmployeesRepositoryNotAccesibleException(e);
        }
    }

    private Employee getEmployee(String str) {
        String[] employeeData = str.split(", ");
        try {
            return new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
        } catch (ParseException e) {
            throw new EmployeeParseException(e);
        }
    }
}
