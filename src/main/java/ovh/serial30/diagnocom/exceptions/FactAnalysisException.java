package ovh.serial30.diagnocom.exceptions;

public class FactAnalysisException extends Exception {
    public int statusCode;
    public FactAnalysisException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
