package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BirthdayService {
	private final EmployeeRepository employeeRepository;
	private final MessagingService messagingService;

	public BirthdayService(EmployeeRepository employeeRepository, MessagingService messagingService) {
		this.employeeRepository = employeeRepository;
		this.messagingService = messagingService;
	}

	public void sendGreetings(XDate xDate) throws IOException, ParseException, MessagingException {
		List<Employee> employees = employeeRepository.loadEmployees();
		for (Employee employee : employees) {
			if (employee.isBirthday(xDate)) {
				String recipient = employee.getEmail();
				String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
				String subject = "Happy Birthday!";
				messagingService.sendMessage( "sender@here.com", subject, body, recipient);
			}
		}
	}
}
