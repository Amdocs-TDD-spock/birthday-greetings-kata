package it.xpug.kata.birthday_greetings;

/**
 * Sending a message (theoretically could be sms, not email, or other messaging systems).
 */
public interface MessagingService {
    void sendMessage(String sender, String subject, String body, String recipient)
            throws MessagingServiceException;
}
