package com.employee.management.system.api;

import javax.validation.constraints.Positive;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeManagementApi {

    String PATH_POST_EMPLOYEE = "/employees";
    String PATH_GET_EMPLOYEES = "/employees";
    String PATH_GET_EMPLOYEE_BY_ID = "/employee/{employee-id}";
    String PATH_PATCH_EMPLOYEE = "/employee/{employee-id}";
    String PATH_DELETE_EMPLOYEE = "/employee/{employee-id}";

    /**
     * Api is used to create the Employee.
     *
     * @param employee
     * @return
     */
    @PostMapping(PATH_POST_EMPLOYEE)
    ResponseEntity<WSEmployeeResponse> addEmployee(@RequestBody WSEmployee employee);

    /**
     * Api is used to get the Employee for given id
     *
     * @param empId
     * @return
     */
    @GetMapping(PATH_GET_EMPLOYEE_BY_ID)
    ResponseEntity<WSEmployee> searchEmployee(@Positive @PathVariable("employee-id") Integer empId);

    /**
     * Api is used to get all Employees.
     *
     * @return
     */
    @GetMapping(PATH_GET_EMPLOYEES)
    ResponseEntity<WSEmployeesResponse> fetchEmployees();

    /**
     * This api is used to update the employee.
     *
     * @return
     */
    @PatchMapping(PATH_PATCH_EMPLOYEE)
    ResponseEntity<Void> updateEmployee(@Positive @PathVariable("employee-id") Integer empId, @RequestBody WSEmployee request);

    /**
     * This api is used to delete the employee for given id.
     *
     * @return
     */
    @DeleteMapping(PATH_DELETE_EMPLOYEE)
    ResponseEntity<Void> deleteEmployee(@Positive @PathVariable("employee-id") Integer empId);


}
