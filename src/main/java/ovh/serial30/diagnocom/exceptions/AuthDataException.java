package ovh.serial30.diagnocom.exceptions;

public class AuthDataException extends Exception {
    public int statusCode;
    public AuthDataException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
