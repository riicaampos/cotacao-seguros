package br.com.seguros.seguros.controller;

import br.com.seguros.seguros.controller.dtos.CotacaoRequest;
import br.com.seguros.seguros.controller.dtos.CotacaoResponse;
import br.com.seguros.seguros.service.CotacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/cotacao")
@Slf4j
public class CotacaoController {

     @Autowired
     CotacaoService service;

    @PostMapping
    public ResponseEntity<CotacaoResponse> criarCotacao(@RequestBody CotacaoRequest request){
        log.info("Chamando o serviço de cotação");
        return ResponseEntity.ok(service.criarCotacao(request));
    }

}
