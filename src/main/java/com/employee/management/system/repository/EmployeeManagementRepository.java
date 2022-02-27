package com.employee.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee.management.system.entity.Employee;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Repository
public interface EmployeeManagementRepository extends JpaRepository<Employee,Integer> {
}
