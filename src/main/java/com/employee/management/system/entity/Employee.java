package com.employee.management.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_IDS")
    @SequenceGenerator(name = "EMP_IDS", sequenceName = "EMP_IDS", allocationSize = 1)
    private Integer id;
    private String name;
    private Double salary;
    private String dept;
}
