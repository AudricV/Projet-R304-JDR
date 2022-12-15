package fr.univ_amu.iut.exceptions;

/**
 * Exception class when a character of an adventure is missing.
 */
public class MissingCharacterException extends Exception {
    public MissingCharacterException(String message) {
        super(message);
    }
}
