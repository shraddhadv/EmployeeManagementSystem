package com.employee.management.system.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.employee.management.system.service.EmployeeVO;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WSEmployee {
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty @Positive
    private Double salary;
    private String dept;

    public WSEmployee(EmployeeVO employeeVO) {
        this.id = employeeVO.getId();
        this.name = employeeVO.getName();
        this.salary = employeeVO.getSalary();
        this.dept = employeeVO.getDept();
    }

    public EmployeeVO toVO() {
        return EmployeeVO.builder()
                .name(this.name)
                .salary(this.salary)
                .dept(this.dept)
                .build();

    }



}
