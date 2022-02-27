package com.employee.management.system.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Setter
@Getter
public class EmployeeNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    String message;
    String issue;

    public EmployeeNotFoundException(String message,String cause){
        super();
        this.message=message;
        this.issue=cause;
    }
}
