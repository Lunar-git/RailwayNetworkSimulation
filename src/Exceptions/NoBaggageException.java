package Exceptions;

public class NoBaggageException extends Exception{
    public NoBaggageException(String message) {
        System.out.println(message);
    }
}
