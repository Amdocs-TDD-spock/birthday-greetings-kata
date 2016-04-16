package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee Repository implementation which reads CSV employees lines from a BufferedReader.
 */
public class CsvReaderEmployeeRepository implements EmployeeRepository {
    private final BufferedReader in;

    public CsvReaderEmployeeRepository(BufferedReader bufferedReader) {
        this.in = bufferedReader;
    }

    public List<Employee> loadEmployees() throws IOException, ParseException {
        List<Employee> employees = new ArrayList<Employee>();
        String str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            employees.add(employee);
        }
        return employees;
    }
}
