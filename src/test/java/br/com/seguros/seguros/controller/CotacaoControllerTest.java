package br.com.seguros.seguros.controller;

import br.com.seguros.seguros.service.CotacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CotacaoController.class)
public class CotacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CotacaoService service;

    @Test
    void deveTestarSucessoNaRequisicao() throws Exception {
        String json = """
                {
                        "customer": {
                            "name": "Ricardo",
                            "document": "abc123",
                            "birthday": "1991-09-24",
                            "location": "BH",
                            "vehicleValue": 80000
                        }
                }
                """;

        mockMvc.perform(post("/v1/cotacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}
