package com.employee.management.system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.http.HttpStatus;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WSEmployeeException {
    private HttpStatus errorCode;
    private String errorMessage;
    private String cause;
}
