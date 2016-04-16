package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

public class BirthdayService {
	private final EmployeeRepository employeeRepository;
	private final MessagingService messagingService;

	public BirthdayService(EmployeeRepository employeeRepository, MessagingService messagingService) {
		this.employeeRepository = employeeRepository;
		this.messagingService = messagingService;
	}

	public void sendGreetings(XDate date) throws IOException, ParseException, MessagingException {
		employeeRepository.loadEmployees()
				.filter(employee -> employee.isBirthday(date))
				.forEach(employee-> createMessageAndSend(employee));
	}

	private void sendCongrats(List<Employee> employeesWithBirthdayToday) throws MessagingException {
		for (Employee employee : employeesWithBirthdayToday) {
			createMessageAndSend(employee);
		}
	}

	private void createMessageAndSend(Employee employee) {
		String recipient = employee.getEmail();
		String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
		String subject = "Happy Birthday!";
		messagingService.sendMessage( "sender@here.com", subject, body, recipient);
	}

}
