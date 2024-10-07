package ovh.serial30.diagnocom.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import ovh.serial30.diagnocom.pojos.response.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class  GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(FactAnalysisException.class)
    public ResponseEntity<?> factAnalysisException(FactAnalysisException e) {
        var response = new MessageResponse();
        response.setStatus(e.statusCode);
        response.setData(e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(AuthDataException.class)
    public ResponseEntity<?> authDataException(AuthDataException e) {
        var response = new MessageResponse();
        response.setStatus(e.statusCode);
        response.setData(e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<?> tokenException(TokenException e) {
        var response = new MessageResponse();
        response.setStatus(e.statusCode);
        response.setData(e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> serverException(Exception e) {
        var response = new MessageResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setData(e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<?> serverException(ServerException e) {
        var response = new MessageResponse();
        response.setStatus(e.statusCode);
        response.setData(e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<?> jsonException(JsonProcessingException e) {
        var response = new MessageResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setData(e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityViolationException(DataIntegrityViolationException e) {
        var response = new MessageResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setData(e.getCause().getMessage().contains("duplica") ? "Datos de registro ya existentes" : e.getMessage());
        err(response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    private void err(MessageResponse response) {
        logger.error("Status ({}) - Mensaje: {}", response.getStatus(), response.getData());
    }
}
