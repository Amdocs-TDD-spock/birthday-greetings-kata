package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		CsvEmployeeRepository employeeRepository = new CsvEmployeeRepository(new File("employee_data.txt"));
		BirthdayService service = new BirthdayService(employeeRepository);
		service.sendGreetings(new XDate(), "localhost", 25);
	}

}
