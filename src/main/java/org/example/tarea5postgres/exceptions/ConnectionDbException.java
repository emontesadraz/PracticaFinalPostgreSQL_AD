package org.example.tarea5postgres.exceptions;

public class ConnectionDbException extends RuntimeException{
    public ConnectionDbException(String message) {
        super(message);
    }
}
