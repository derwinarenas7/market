package com.market.market.dao;

import com.market.market.dto.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeDAOTest {

    private EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAO(); // usa los datos simulados
    }

    @Test
    void testFindByExistingPosition() {
        List<EmployeeDTO> result = dao.findByPosition("Cashier");
        assertEquals(3, result.size());
        assertEquals("Carlos Rodriguez", result.get(0).getName());
    }

    @Test
    void testFindByNonExistingPosition() {
        List<EmployeeDTO> result = dao.findByPosition("Role Manager");
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindByPositionIgnoreCase() {
        List<EmployeeDTO> result = dao.findByPosition("cAshieR");
        assertEquals(3, result.size());
        assertEquals("Carlos Rodriguez", result.get(0).getName());
    }

    @Test
    void testFindByPosition_StoreManager() {
        List<EmployeeDTO> result = dao.findByPosition("Store Manager");
        assertEquals(1, result.size(), "Debe existir 1 Store Manager");
        assertEquals("Derwin Arenas", result.get(0).getName());
    }

    @Test
    void testFindByPosition_DepartmentSupervisor() {
        List<EmployeeDTO> result = dao.findByPosition("Department Supervisor");
        assertEquals(1, result.size(), "Debe existir 1 Department Supervisor");
        assertEquals("Jhon F. Cervantes", result.get(0).getName());
    }

    @Test
    void testFindByPosition_StockClerk() {
        List<EmployeeDTO> result = dao.findByPosition("Stock Clerk");
        assertEquals(2, result.size(), "Deben existir 2 Stock Clerk");
        assertEquals(List.of("Mauricio Rodriguez", "Santiago García"),
                List.of(result.get(0).getName(), result.get(1).getName()));
    }

    @Test
    void testFindByPosition_CustomerService() {
        List<EmployeeDTO> result = dao.findByPosition("Customer Service");
        assertEquals(3, result.size(), "Deben existir 3 Customer Service");
        assertEquals(List.of("Juan Rondón", "Angie Diaz", "Jaider Hurtado"),
                List.of(result.get(0).getName(), result.get(1).getName(), result.get(2).getName()));
    }



}
