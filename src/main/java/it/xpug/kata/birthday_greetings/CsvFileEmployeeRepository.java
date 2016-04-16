package it.xpug.kata.birthday_greetings;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * Employee Repository implementation which reads from a file.
 */
public class CsvFileEmployeeRepository implements EmployeeRepository {
    private final CsvReaderEmployeeRepository employeeRepository;
    private File fileName;

    public CsvFileEmployeeRepository(File fileName) {
        this.fileName = fileName;
        this.employeeRepository = new CsvReaderEmployeeRepository();
    }

    public List<Employee> loadEmployees() {
        BufferedReader reader = createReader();
        return employeeRepository.loadEmployees(reader);
    }

    private BufferedReader createReader() {
        try {
            return new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new EmployeesRepositoryNotAccesibleException(e);
        }
    }
}
