package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		File file = new File("employee_data.txt");
		EmployeeRepository employeeRepository = new FileEmployeeRepository(file);
		BirthdayService service = new BirthdayService(employeeRepository);
		service.sendGreetings("employee_data.txt", new XDate(), "localhost", 25);
	}

}
