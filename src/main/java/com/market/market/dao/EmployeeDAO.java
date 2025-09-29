package com.market.market.dao;

import com.market.market.dto.EmployeeDTO;
import com.market.market.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDAO {

    private List<Employee> employees;

    public EmployeeDAO() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Derwin Arenas", "Store Manager"));
        employees.add(new Employee(2, "Jhon F. Cervantes", "Department Supervisor"));
        employees.add(new Employee(3, "Carlos Rodriguez", "Cashier"));
        employees.add(new Employee(4, "Mauricio Rodriguez", "Stock Clerk"));
        employees.add(new Employee(5, "Juan Rondón", "Customer Service"));
        employees.add(new Employee(6, "Santiago García", "Stock Clerk"));
        employees.add(new Employee(7, "Jose Diaz", "Cashier"));
        employees.add(new Employee(8, "Angie Diaz", "Customer Service"));
        employees.add(new Employee(9, "Eliza Andrade", "Cashier"));
        employees.add(new Employee(10, "Jaider Hurtado", "Customer Service"));
    }

    public List<EmployeeDTO> findByPosition(String position) {
        return employees.stream()
                .filter(e -> e.getPosition().equalsIgnoreCase(position))
                .map(e -> EmployeeDTO.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .position(e.getPosition())
                        .build())
                .collect(Collectors.toList());
    }


}
