package it.xpug.kata.birthday_greetings;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) {
		BirthdayService service = getBirthdayService();
		service.sendGreetings(new XDate());
	}

	public static BirthdayService getBirthdayService() {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(GreetingSpringConfig.class);
//		EmployeeRepository employeeRepository = new CsvFileEmployeeRepository(new File("employee_data.txt"));
//		MessagingService messagingService = new EmailMessagingService ("localhost", 25);
		return context.getBean(BirthdayService.class);
	}

}
