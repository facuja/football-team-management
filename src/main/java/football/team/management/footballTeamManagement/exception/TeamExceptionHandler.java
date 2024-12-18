package football.team.management.footballTeamManagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeamExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomError> handleRuntimeException(RuntimeException ex) {
        LOGGER.error("RuntimeException: {}", ex.getMessage(), ex);
        CustomError error = new CustomError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                500L
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleException(Exception ex) {
        LOGGER.error("UnexpectedError: {}", ex.getMessage(), ex);
        CustomError error = new CustomError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                400L
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(TeamException.class)
    public ResponseEntity<CustomError> validationException(TeamException ex) {
        LOGGER.error("TeamException: {}", ex.getMessage(), ex);
        CustomError error = new CustomError(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                ex.getCode()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOGGER.error("MethodArgumentNotValidException: {}", ex.getMessage(), ex);
        CustomError error = new CustomError(
                HttpStatus.BAD_REQUEST,
                "La solicitud es invalida",
                400L
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<CustomError> invalidCredentialsException(InvalidCredentialsException ex) {
        LOGGER.error("InvalidCredentialsException: {}", ex.getMessage(), ex);
        CustomError error = new CustomError(
                HttpStatus.UNAUTHORIZED,
                ex.getMessage(),
                ex.getCode()
        );
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
