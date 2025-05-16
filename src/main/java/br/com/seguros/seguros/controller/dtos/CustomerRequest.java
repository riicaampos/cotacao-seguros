package br.com.seguros.seguros.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    @NotBlank(message = "campo 'cliente' é obrigatorio")
    private String name;
    private String document;
    private String birthday;
    @NotBlank(message = "campo 'location' é obrigatorio")
    private String location;
    @NotNull(message = "campo 'vehicleValue' é obrigatorio")
    private BigDecimal vehicleValue;
}
