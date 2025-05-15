package br.com.seguros.seguros.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CotacaoResponse {
    private String name;
    private String location;
    private BigDecimal value;

}
