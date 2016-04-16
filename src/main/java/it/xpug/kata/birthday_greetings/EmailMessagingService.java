package it.xpug.kata.birthday_greetings;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 */
public class EmailMessagingService implements MessagingService {
    private final Properties props;

    public EmailMessagingService(String smtpHost, int smtpPort) {
        props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
    }

    public void sendMessage(String sender, String subject, String body, String recipient) {
        // Create a mail session
        Session session = Session.getInstance(props, null);

        try{
        // Construct the message
        Message msg = createEmailMessage(sender, subject, body, recipient, session);

        // Send the message
        Transport.send(msg);
        } catch (MessagingException e) {
            throw new MessagingServiceException(e);
        }
    }

    private Message createEmailMessage(String sender, String subject, String body, String recipient, Session session) throws MessagingException {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        msg.setSubject(subject);
        msg.setText(body);
        return msg;
    }
}
