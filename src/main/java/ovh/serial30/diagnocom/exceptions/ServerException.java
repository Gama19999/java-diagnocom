package ovh.serial30.diagnocom.exceptions;

public class ServerException extends Exception {
    public int statusCode;
    public ServerException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
