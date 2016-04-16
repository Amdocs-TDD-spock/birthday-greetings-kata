package it.xpug.kata.birthday_greetings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

/**
 * Spring context configuration class.
 */
@Configuration
@PropertySource("birthdayService.properties")
public class GreetingSpringConfig {
    @Bean
    public BirthdayService birthdayService(MessagingService messagingService,
                                           EmployeeRepository employeeRepository) {
        return new BirthdayService(employeeRepository, messagingService);
    }

    @Bean
    public MessagingService messagingService(
            @Value("${smtp.host}") String smtpHost,
            @Value("${smtp.port}") int smtpPort) {
        return new EmailMessagingService(smtpHost, smtpPort);
    }

    @Bean
    public EmployeeRepository employeeRepository( @Value("${input.file}") File inputFile) {
        return new CsvFileEmployeeRepository(inputFile);
    }
}
