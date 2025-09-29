package com.market.market.controller;

import com.market.market.dao.EmployeeDAO;
import com.market.market.dto.EmployeeDTO;
import com.market.market.view.EmployeeView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerPositionTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @Mock
    private EmployeeView employeeView;

    @InjectMocks
    private EmployeeController controller;

    @Test
    @DisplayName("Debe delegar en el DAO y pasar a la vista los empleados por cargo (Cashier)")
    void shouldDelegateToDaoAndPassResultToView_Cashier() {
        String position = "Cashier";
        List<EmployeeDTO> expected = List.of(
                EmployeeDTO.builder().id(3).name("Carlos Rodriguez").position(position).build(),
                EmployeeDTO.builder().id(7).name("Jose Diaz").position(position).build(),
                EmployeeDTO.builder().id(8).name("Eliza Andrade").position(position).build()
        );


        when(employeeDAO.findByPosition(position)).thenReturn(expected);

        controller.findByPosition(position);

        verify(employeeDAO).findByPosition(position);
        verify(employeeView).showEmployee(expected);
        verifyNoMoreInteractions(employeeDAO, employeeView);
    }

    @Test
    @DisplayName("Debe delegar en el DAO y pasar a la vista los empleados por cargo (Stock Clerk)")
    void shouldDelegateToDaoAndPassResultToView_StockClerk() {
        String position = "Stock Clerk";
        List<EmployeeDTO> expected = List.of(
                EmployeeDTO.builder().id(4).name("Mauricio Rodriguez").position(position).build(),
                EmployeeDTO.builder().id(6).name("Santiago García").position(position).build()
        );


        when(employeeDAO.findByPosition(position)).thenReturn(expected);

        controller.findByPosition(position);

        verify(employeeDAO).findByPosition(position);
        verify(employeeView).showEmployee(expected);
        verifyNoMoreInteractions(employeeDAO, employeeView);
    }

    @Test
    @DisplayName("Debe manejar lista vacía cuando no hay empleados para el cargo")
    void shouldHandleEmptyListWhenNoEmployeesForPosition() {
        String position = "Non Existing";
        when(employeeDAO.findByPosition(position)).thenReturn(List.of());

        controller.findByPosition(position);

        ArgumentCaptor<List<EmployeeDTO>> captor = ArgumentCaptor.forClass(List.class);
        verify(employeeDAO).findByPosition(position);
        verify(employeeView).showEmployee(captor.capture());
        assertEquals(0, captor.getValue().size());
        verifyNoMoreInteractions(employeeDAO, employeeView);
    }

    @Test
    @DisplayName("Debe soportar búsqueda case-insensitive en el controlador (delegada al DAO)")
    void shouldSupportCaseInsensitiveDelegation() {
        String positionQuery = "cUsToMeR sErViCe";
        String normalized = "Customer Service";
        List<EmployeeDTO> expected = List.of(
                EmployeeDTO.builder().id(5).name("Juan Rondón").position(normalized).build(),
                EmployeeDTO.builder().id(8).name("Angie Diaz").position(normalized).build(),
                EmployeeDTO.builder().id(8).name("Jaider Hurtado").position(normalized).build()
        );


        when(employeeDAO.findByPosition(positionQuery)).thenReturn(expected);

        controller.findByPosition(positionQuery);

        verify(employeeDAO).findByPosition(positionQuery);
        verify(employeeView).showEmployee(expected);
        verifyNoMoreInteractions(employeeDAO, employeeView);
    }
}
