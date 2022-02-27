package com.employee.management.system.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.EmployeeManagementRepository;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeManagementServiceTest {

    @InjectMocks
    private EmployeeManagementServiceImpl target;

    @Mock
    private EmployeeManagementRepository mockEmployeeManagementRepository;

    @Test
    public void testSearchEmployee() {
        EmployeeVO employeeVO = buildEmployee();
        List<EmployeeVO> employeeVOList = new ArrayList<>();
        employeeVOList.add(employeeVO);
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(buildEmployeeDto());
        when(mockEmployeeManagementRepository.findAll()).thenReturn(employeesList);
        Assertions.assertThat(target.fetchEmployees()).isEqualTo(employeeVOList);
        verify(mockEmployeeManagementRepository, times(1)).findAll();
    }


    private Employee buildEmployeeDto() {
        Employee employee = new Employee();
        employee.setDept("IT");
        employee.setName("Shraddha");
        employee.setSalary(50000.0);
        return employee;
    }

    private EmployeeVO buildEmployee() {
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setDept("IT");
        employeeVO.setName("Shraddha");
        employeeVO.setSalary(50000.0);
        return employeeVO;
    }
}
