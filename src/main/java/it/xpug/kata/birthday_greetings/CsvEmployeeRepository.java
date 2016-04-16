package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee Repository implementation which reads from a file.
 */
public class CsvEmployeeRepository implements EmployeeRepository {
    private final File fileName;

    public CsvEmployeeRepository(File fileName) {
        this.fileName = fileName;
    }

    public List<Employee> loadEmployees() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        return loadEmployees(reader);
    }

    public List<Employee> loadEmployees(BufferedReader in) throws IOException, ParseException {
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
