package com.market.market;

import com.market.market.controller.EmployeeController;
import com.market.market.dao.EmployeeDAO;
import com.market.market.view.EmployeeView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(dao, view);

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el cargo a consultar: ");
        String position = sc.nextLine();

        controller.findByPosition(position);
	}

}
