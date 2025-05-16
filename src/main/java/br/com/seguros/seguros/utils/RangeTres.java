package br.com.seguros.seguros.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class RangeTres implements VerificaDesconto{

    private final BigDecimal maxValue = BigDecimal.valueOf(100000);
    private final BigDecimal minValue = BigDecimal.valueOf(0.04);

    @Override
    public boolean valida(BigDecimal valorVeiculo) {
        return valorVeiculo.compareTo(maxValue) >= 0;
    }

    @Override
    public BigDecimal calcula(BigDecimal valorVeiculo, String cidade) {
        log.info("Calculando pela range 3");
        return valorVeiculo.multiply(minValue);
    }
}
