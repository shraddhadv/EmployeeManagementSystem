package com.employee.management.system.service;

import java.util.List;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
public interface EmployeeManagementService {

    Integer addEmployee(EmployeeVO employeeVO);

    EmployeeVO fetchEmployee(Integer empId);

    List<EmployeeVO> fetchEmployees();

    void updateEmployee(EmployeeVO vo, Integer empId);

    void deleteEmployee(Integer empId);
}
