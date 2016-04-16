package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;

/**
 * Created by dnmaras on 4/16/16.
 */
public interface MessagingService {
    void sendMessage(String sender, String subject, String body, String recipient) throws MessagingException ;
}
