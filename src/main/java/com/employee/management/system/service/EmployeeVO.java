package com.employee.management.system.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

import com.employee.management.system.entity.Employee;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeVO {
    private Integer id;
    private String name;
    private Double salary;
    private String dept;

    public EmployeeVO(Optional<Employee> employee) {
        if (employee == null) {
            return;
        }
        this.id = employee.get().getId();
        this.name = employee.get().getName();
        this.salary = employee.get().getSalary();
        this.dept = employee.get().getDept();
    }

    public Employee fromDTO() {
        Employee employee = new Employee();
        employee.setId(this.id);
        employee.setName(this.name);
        employee.setSalary(this.salary);
        employee.setDept(this.dept);
        return employee;
    }

    public EmployeeVO(Employee dto) {
        if (dto == null) {
            return;
        }
        this.id = dto.getId();
        this.name = dto.getName();
        this.salary = dto.getSalary();
        this.dept = dto.getDept();
    }
}
