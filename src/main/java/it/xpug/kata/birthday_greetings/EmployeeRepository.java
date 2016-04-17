package it.xpug.kata.birthday_greetings;

import java.util.List;

/**
 * Created by dnmaras on 4/17/16.
 */
public interface EmployeeRepository {
    List<Employee> loadEmployees();
    void addEmployee(Employee e);
    void removeEmployee(Employee e);
}
