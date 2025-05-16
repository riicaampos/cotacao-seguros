package br.com.seguros.seguros.utils;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j
public class VerificaDescontoChain {

    @Autowired
    private RangeUm rangeUm;
    @Autowired
    private  RangeDois rangeDois;
    @Autowired
    private  RangeTres rangeTres;

    private List<VerificaDesconto> regras;

    @PostConstruct
    public void init() {
        regras = List.of(rangeUm, rangeDois, rangeTres);
    }

    public BigDecimal calcular(BigDecimal valorVeiculo, String cidade) {
        log.info("Busacando a regra de calculo");
        return regras.stream()
                .filter(regra -> regra.valida(valorVeiculo))
                .findFirst()
                .map(regra -> regra.calcula(valorVeiculo, cidade))
                .orElseThrow(() -> new IllegalArgumentException("Valor fora das faixas"));
    }
}
