package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnmaras on 4/16/16.
 */
public class EmployeeRepository {
    private final  File fileName;

    public EmployeeRepository(File fileName) {
        this.fileName = fileName;
    }

    public List<Employee> getEmployees() throws IOException, ParseException {
        List<Employee> employees = new ArrayList<Employee>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            employees.add(employee);
        }
        return employees;

    }
}
