package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		EmployeeRepository employeeRepository = new CsvFileEmployeeRepository(new File("employee_data.txt"));
		MessagingService messagingService = new EmailMessagingService ("localhost", 25);
		BirthdayService service = new BirthdayService(employeeRepository, messagingService);
		service.sendGreetings(new XDate());
	}

}
