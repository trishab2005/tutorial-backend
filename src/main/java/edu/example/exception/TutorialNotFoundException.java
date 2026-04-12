package edu.example.exception;

public class TutorialNotFoundException extends RuntimeException{
    public TutorialNotFoundException(String message) {
        super(message);
    }
}
