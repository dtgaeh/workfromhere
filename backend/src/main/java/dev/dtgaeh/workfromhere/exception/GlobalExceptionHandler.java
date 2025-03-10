package dev.dtgaeh.workfromhere.exception;

import dev.dtgaeh.workfromhere.spaces.exception.SpaceResourceException;
import dev.dtgaeh.workfromhere.users.exception.UserResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SpaceResourceException.class)
    public ResponseEntity<ErrorResponse> handleSpaceNotFoundException(SpaceResourceException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserResourceException.class)
    public ResponseEntity<ErrorResponse> handleUserResourceException(UserResourceException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
