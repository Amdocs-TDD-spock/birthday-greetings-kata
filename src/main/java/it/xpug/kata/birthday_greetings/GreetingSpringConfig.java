package it.xpug.kata.birthday_greetings;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

/**
 * Spring context configuration class.
 */
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
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("birthdayService.properties"));
        return configurer;
    }
}
