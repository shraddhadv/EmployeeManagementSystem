package com.employee.management.system.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.management.system.entity.Employee;
import com.employee.management.system.exception.EmployeeNotFoundException;
import com.employee.management.system.repository.EmployeeManagementRepository;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private EmployeeManagementRepository employeeManagementRepository;

    @Override
    public Integer addEmployee(EmployeeVO employeeVO) {
        Employee employee = employeeManagementRepository.save(employeeVO.fromDTO());
        return employee.getId();
    }

    @Override
    public EmployeeVO fetchEmployee(Integer empId) {
        Optional<Employee> employee = getEmployee(empId);
        return new EmployeeVO(employee);
    }

    @Override
    public List<EmployeeVO> fetchEmployees() {
        List<Employee> employee = employeeManagementRepository.findAll();
        if (CollectionUtils.isEmpty(employee)) {
            throw new EmployeeNotFoundException("Employee", "general.records.not.found");
        }
        return employee.stream()
                .map(EmployeeVO::new)
                .sorted(Comparator.comparingInt(EmployeeVO::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void updateEmployee(EmployeeVO vo, Integer empId) {
        Optional<Employee> emp = getEmployee(empId);
        Employee employee = emp.get();
        if (vo.getName() != null && !(employee.getName().equalsIgnoreCase(vo.getName()))) {
            employee.setName(vo.getName());
        }
        if (vo.getDept() != null && !(employee.getDept().equalsIgnoreCase(vo.getDept()))) {
            employee.setDept(vo.getDept());
        }
        if (vo.getSalary() != null && (employee.getSalary() != vo.getSalary())) {
            employee.setSalary(vo.getSalary());
        }
        employeeManagementRepository.saveAndFlush(employee);
    }

    @Override
    public void deleteEmployee(Integer empId) {
        getEmployee(empId);
        employeeManagementRepository.deleteById(empId);
    }

    //Check employee is present in DB.
    private Optional<Employee> getEmployee(Integer empId) {
        Optional<Employee> employee = employeeManagementRepository.findById(empId);
        if (employee.isEmpty()) {
            logger.debug("At: EmployeeManagementServiceImpl::getEmployee,record not present");
            throw new EmployeeNotFoundException("Employee not found for ID : " + empId, "general.record.not.found");
        }
        return employee;
    }
}
