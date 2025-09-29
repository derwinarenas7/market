package com.market.market.controller;

import com.market.market.dao.EmployeeDAO;
import com.market.market.dto.EmployeeDTO;
import com.market.market.view.EmployeeView;

import java.util.List;

public class EmployeeController {

    private EmployeeDAO dao;
    private EmployeeView view;

    public EmployeeController(EmployeeDAO employeeDAO, EmployeeView employeeView) {
        this.dao = employeeDAO;
        this.view = employeeView;
    }

    public void findByPosition(String position) {
        List<EmployeeDTO> employees = dao.findByPosition(position);
        view.showEmployee(employees);
    }

}
