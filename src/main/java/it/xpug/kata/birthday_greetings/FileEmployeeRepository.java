package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnmaras on 4/17/16.
 */
public class FileEmployeeRepository implements EmployeeRepository {
    private final File file;

    public FileEmployeeRepository(File file) {
        this.file = file;
    }

    public List<Employee> loadEmployees() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str = "";
            str = in.readLine(); // skip header
            List<Employee> employees = new ArrayList<Employee>();
            while ((str = in.readLine()) != null) {
                Employee employee = parseEmployee(str);
                employees.add(employee);
            }
            return employees;
        }catch(Exception e){
            throw new GreetingsException(e);
        }
    }

    private Employee parseEmployee(String str) throws ParseException {
        String[] employeeData = str.split(", ");
        return new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
    }
}
