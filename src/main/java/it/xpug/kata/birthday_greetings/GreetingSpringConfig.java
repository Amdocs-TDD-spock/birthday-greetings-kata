package it.xpug.kata.birthday_greetings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Spring context configuration class.
 */
public class GreetingSpringConfig {

    @Bean
    public BirthdayService birthdayService(){
        return new BirthdayService(employeeRepository(), messagingService());
    }

    @Bean
    public MessagingService messagingService(
            @Value("${smtp.host}" smtpHost,)
    ) {
        return new EmailMessagingService("localhost", 25);
    }

    @Bean
    public EmployeeRepository employeeRepository() {
        return new CsvFileEmployeeRepository(new File("employee_data.txt"));
    }
}
