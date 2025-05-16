package br.com.seguros.seguros.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class RangeUm implements VerificaDesconto{

    private final BigDecimal maxValue = BigDecimal.valueOf(70000);
    private final BigDecimal percent = BigDecimal.valueOf(0.04);
    private final BigDecimal spPercent = BigDecimal.valueOf(0.05);

    @Override
    public boolean valida(BigDecimal valorVeiculo) {
        return valorVeiculo.compareTo(maxValue) <= 0;
    }

    @Override
    public BigDecimal calcula(BigDecimal valorVeiculo, String cidade) {
        log.info("Calculando pela range 1");
        return valorVeiculo.multiply(cidade.equalsIgnoreCase("SP") ? spPercent : percent);
    }
}
