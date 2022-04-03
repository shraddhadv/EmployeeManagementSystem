package com.employee.management.system.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.management.system.service.EmployeeManagementService;
import com.employee.management.system.service.EmployeeVO;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@RequestMapping("/empMgmtApi/v1")
@RestController("empMgmtApi_" + EmployeeManagementApiImpl.API_VERSION)
public class EmployeeManagementApiImpl implements EmployeeManagementApi {

    public static final String API_VERSION = "v1";

    @Autowired
    private EmployeeManagementService employeeManagementService;

    @Override
    public ResponseEntity<WSEmployeeResponse> addEmployee(WSEmployee employee) {
        Integer id = employeeManagementService.addEmployee(employee.toVO());
        WSEmployeeResponse response = new WSEmployeeResponse();
        System.out.println("1");
        response.setEmpId(id);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<WSEmployee> searchEmployee(Integer empId) {
        EmployeeVO employee = employeeManagementService.fetchEmployee(empId);
        WSEmployee response = new WSEmployee(employee);
        System.out.println("2");
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<WSEmployeesResponse> fetchEmployees() {
        List<EmployeeVO> employee = employeeManagementService.fetchEmployees();
        WSEmployeesResponse response = new WSEmployeesResponse(employee);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<Void> updateEmployee(Integer empId, WSEmployee request) {
        System.out.println("3");
        employeeManagementService.updateEmployee(request.toVO(), empId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Integer empId) {
        employeeManagementService.deleteEmployee(empId);
        return ResponseEntity.ok().build();
    }
}
