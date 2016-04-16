package it.xpug.kata.birthday_greetings;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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

	public void sendGreetings(XDate date){
		List<Employee> allEmployees = allEmployees();
		List<Employee> employeesWithBirthdayToday = selectCelebratedEmployees(date, allEmployees);
		sendCongrats(employeesWithBirthdayToday);
	}

	private void sendCongrats(List<Employee> employeesWithBirthdayToday) {
		for (Employee employee : employeesWithBirthdayToday) {
			String recipient = employee.getEmail();
			String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
			String subject = "Happy Birthday!";
			messagingService.sendMessage( "sender@here.com", subject, body, recipient);
		}
	}

	private List<Employee> allEmployees() {
		return employeeRepository.loadEmployees();
	}

	private List<Employee> selectCelebratedEmployees(XDate date, List<Employee> employees) {
		List<Employee> employeesWithBirthdayToday = new ArrayList<Employee>();
		for (Employee employee : employees) {
			if (employee.isBirthday(date)) {
				employeesWithBirthdayToday.add(employee);
			}
		}
		return employeesWithBirthdayToday;
	}
}
