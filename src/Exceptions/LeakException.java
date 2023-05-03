package Exceptions;

public class LeakException extends Exception {
    public LeakException(String message) {
        System.out.println(message);
    }
}
