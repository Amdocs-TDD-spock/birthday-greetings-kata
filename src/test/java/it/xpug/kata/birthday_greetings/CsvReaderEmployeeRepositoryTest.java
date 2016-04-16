package it.xpug.kata.birthday_greetings;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

/**
 * Created by dnmaras on 4/16/16.
 */
public class CsvReaderEmployeeRepositoryTest {
    @Test
    public void testLoadEmployeesFromBufferedReader() throws ParseException, IOException {
        List<Employee> expectedEmployees= Collections.singletonList(  new Employee( "John","Doe", "1982/10/08", "john.doe@foobar.com"));
        BufferedReader bufferedReader = new BufferedReader(new StringReader("header\r\n" +
                "Doe, John, 1982/10/08, john.doe@foobar.com\r\n"));
        List<Employee> actualEmployees = new CsvReaderEmployeeRepository().loadEmployees(bufferedReader);
        assertEquals(expectedEmployees, actualEmployees);
    }
}
