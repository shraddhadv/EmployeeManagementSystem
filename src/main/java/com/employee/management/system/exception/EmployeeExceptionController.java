package com.employee.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@ControllerAdvice
public class EmployeeExceptionController {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> employeeNotFoundException(EmployeeNotFoundException ex) {
        WSEmployeeException exception = new WSEmployeeException();
        exception.setErrorCode(HttpStatus.BAD_REQUEST);
        exception.setErrorMessage(ex.getMessage());
        exception.setCause(ex.getIssue());
        return new ResponseEntity<Object>(exception, exception.getErrorCode());
    }
}
