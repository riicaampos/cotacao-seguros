package br.com.seguros.seguros.utils;

import java.math.BigDecimal;

public interface VerificaDesconto {

    boolean valida(BigDecimal valorVeiculo);
    BigDecimal calcula(BigDecimal valorVeiculo, String cidade);
}
