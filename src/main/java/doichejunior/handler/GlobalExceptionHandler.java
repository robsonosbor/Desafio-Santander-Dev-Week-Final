package doichejunior.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY); //422
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoudException) {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND); //422
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "Unexpected server error.";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR); //422
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        var message = "NotReadbleException erro 404 bad request!";
        logger.error(message, httpMessageNotReadableException);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleNotReadableException(DataIntegrityViolationException dataIntegrityViolation) {
        var message = "Violação ou campos unicos!";
        logger.error(message, dataIntegrityViolation);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleViolationConstraintException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException) {
        var message = "Violação de primary key!";
        logger.error(message, sqlIntegrityConstraintViolationException);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


    //DataIntegrityViolationException
    //JdbcSQLIntegrityConstraintViolationException


}
