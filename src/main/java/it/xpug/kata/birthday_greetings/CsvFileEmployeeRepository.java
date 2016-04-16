package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee Repository implementation which reads from a file.
 */
public class CsvFileEmployeeRepository implements EmployeeRepository {
    private final EmployeeRepository employeeRepository;

    public CsvFileEmployeeRepository(File fileName) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        this.employeeRepository = new CsvReaderEmployeeRepository(reader);
    }

    public List<Employee> loadEmployees() throws IOException, ParseException {
        return employeeRepository.loadEmployees();
    }
}
