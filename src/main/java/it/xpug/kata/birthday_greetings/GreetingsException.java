package it.xpug.kata.birthday_greetings;

/**
 * Created by dnmaras on 4/17/16.
 */
public class GreetingsException extends RuntimeException {
    public GreetingsException(Exception e) {
        super(e);
    }
}
