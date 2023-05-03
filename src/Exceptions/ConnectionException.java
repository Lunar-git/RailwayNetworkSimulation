package Exceptions;

public class ConnectionException extends Exception{
    public ConnectionException(String message) {
        System.out.println(message);
    }
}
