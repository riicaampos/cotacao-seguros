package br.com.seguros.seguros.service;

import br.com.seguros.seguros.controller.dtos.CotacaoRequest;
import br.com.seguros.seguros.controller.dtos.CotacaoResponse;
import br.com.seguros.seguros.controller.dtos.CustomerRequest;
import br.com.seguros.seguros.utils.VerificaDescontoChain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CotacaoServiceTest {

    @Mock
    private VerificaDescontoChain verificaDesconto;

    @InjectMocks
    private CotacaoService cotacaoService;

    @Test
    void deveCriarCotacaoComDescontoCalculado() {
        CotacaoRequest request = CotacaoRequest.builder()
                .customer(CustomerRequest.builder()
                        .name("Ricardo")
                        .location("BH")
                        .vehicleValue(BigDecimal.valueOf(80000))
                        .build())
                .build();

        BigDecimal descontoCalculado = new BigDecimal("4400.000");
        when(verificaDesconto.calcular(new BigDecimal("80000"), "BH")).thenReturn(descontoCalculado);

        CotacaoResponse response = cotacaoService.criarCotacao(request);

        assertNotNull(response);
        assertNotNull(response.getCustomer());
        assertEquals("Ricardo", response.getCustomer().getName());
        assertEquals("BH", response.getCustomer().getLocation());
        assertEquals(descontoCalculado.setScale(3), response.getCustomer().getValue());

        verify(verificaDesconto, times(1)).calcular(new BigDecimal("80000"), "BH");
    }
}
