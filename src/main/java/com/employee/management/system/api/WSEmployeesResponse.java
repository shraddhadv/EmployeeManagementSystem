package com.employee.management.system.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import com.employee.management.system.service.EmployeeVO;

/**
 * @author Shraddha Vele
 * @since Feb 27, 2022
 */
@Setter
@Getter
@NoArgsConstructor
public class WSEmployeesResponse {
    private List<WSEmployee> employees = Collections.EMPTY_LIST;

    public WSEmployeesResponse(List<EmployeeVO> vo){
        if(vo==null){
            return;
        }
        if(CollectionUtils.isNotEmpty(vo)){
            this.employees = vo.stream().map(WSEmployee::new).collect(Collectors.toList());
        }
    }


}
