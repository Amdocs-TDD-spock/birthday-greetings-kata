package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;

/**
 * Created by dnmaras on 4/16/16.
 */
public class MessagingServiceException extends RuntimeException {
    public MessagingServiceException(MessagingException e) {
    }
}
