package br.com.seguros.seguros.service;

import br.com.seguros.seguros.controller.dtos.CotacaoRequest;
import br.com.seguros.seguros.controller.dtos.CotacaoResponse;
import br.com.seguros.seguros.controller.dtos.CustomerResponse;
import br.com.seguros.seguros.utils.VerificaDescontoChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CotacaoService {

    @Autowired
    private VerificaDescontoChain verificaDesconto;

    public CotacaoResponse criarCotacao(CotacaoRequest request) {
        log.info("Construindo objeto de resposta");
        return CotacaoResponse.builder()
                .customer(
                        CustomerResponse.builder()
                                .name(request.getCustomer().getName())
                                .location(request.getCustomer().getLocation())
                                .value(verificaDesconto.calcular(request.getCustomer().getVehicleValue(), request.getCustomer().getLocation()).setScale(3))
                                .build()
                )
                .build();
    }

}
