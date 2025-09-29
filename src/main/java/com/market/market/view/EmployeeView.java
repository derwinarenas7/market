package com.market.market.view;

import com.market.market.dto.EmployeeDTO;
import com.market.market.model.Employee;
import lombok.*;

import java.util.List;


public class EmployeeView {

    public void showEmployee(List<EmployeeDTO> employees) {
        if (employees.isEmpty()) {
            System.out.println("No se encontraron empleados con ese cargo");
        } else {
            employees.forEach(e ->
                    System.out.println(e.getId() + "-" + e.getName() + "-" + e.getPosition()));
        }
    }

}
