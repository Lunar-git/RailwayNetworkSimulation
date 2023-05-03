package Exceptions;

public class ToxicityException extends Exception {
    public ToxicityException(String message) {
        System.out.println(message);
    }
}