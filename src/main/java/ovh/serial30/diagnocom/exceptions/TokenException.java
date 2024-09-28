package ovh.serial30.diagnocom.exceptions;

public class TokenException extends RuntimeException {
    public int statusCode;
    public TokenException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
