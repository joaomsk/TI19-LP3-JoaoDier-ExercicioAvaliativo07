package br.fundatec.joaodier.finalproject.api.handler;

import br.fundatec.joaodier.finalproject.api.handler.exception.NotFoundException;
import br.fundatec.joaodier.finalproject.domain.vo.PokemonResponseVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {NotFoundException.class})
@RestClientTest
class ExceptionHandlerAdviceTest {

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RestTemplateBuilder builder;

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = this.builder.errorHandler(new ExceptionHandlerAdvice())
                .build();

        Assertions.assertNotNull(this.builder);
        Assertions.assertNotNull(this.server);
        Assertions.assertNotNull(this.restTemplate);
    }

    @Test
    void givenRemoteApiCall_when404Error_thenThrowNotFound() {
        String uri = "https://pokeapi.co/api/v2/pokemon/100000";

        this.server
                .expect(ExpectedCount.once(), requestTo(uri))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        Assertions.assertThrows(NotFoundException.class, () -> restTemplate.getForEntity(uri, PokemonResponseVO.class));
    }
}