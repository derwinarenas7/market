package com.market.market.dto;

import lombok.Builder;
import lombok.Value;

@Value //clase inmutable, solo getters sin setters.
@Builder //Patrón builder para construir objetos de forma fluida.
public class EmployeeDTO {
    int id;
    String name;
    String position;
}
