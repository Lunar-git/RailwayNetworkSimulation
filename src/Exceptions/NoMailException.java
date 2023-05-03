package Exceptions;

public class NoMailException extends Exception{
    public NoMailException(String message) {
        System.out.println(message);
    }
}
