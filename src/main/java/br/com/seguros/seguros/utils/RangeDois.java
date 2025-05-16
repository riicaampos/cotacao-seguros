package br.com.seguros.seguros.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class RangeDois implements VerificaDesconto{

    private final BigDecimal minValue = BigDecimal.valueOf(70000);
    private final BigDecimal maxValue = BigDecimal.valueOf(100000);
    private final BigDecimal percent = BigDecimal.valueOf(0.055);

    @Override
    public boolean valida(BigDecimal valorVeiculo) {
        return valorVeiculo.compareTo(minValue) > 0
                && valorVeiculo.compareTo(maxValue) < 0;
    }

    @Override
    public BigDecimal calcula(BigDecimal valorVeiculo, String cidade) {
        log.info("Calculando pela range 2");
        return valorVeiculo.multiply(percent);
    }
}
