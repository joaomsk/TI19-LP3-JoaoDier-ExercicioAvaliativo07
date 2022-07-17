package br.fundatec.joaodier.finalproject.service.implementation;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PokemonIntegrationServiceTest {

    @Test
    void givenRemoteApiCall_whenCallByAValidPokemonId_thenStatusCode200() {
        given().when()
                .get("http://localhost:8080/api/pokemon/pokeapi/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("bulbasaur"));
    }

    @Test
    void givenRemoteApiCall_whenCallByAValidPokemonName_thenStatusCode200() {
        given().when()
                .get("http://localhost:8080/api/pokemon/pokeapi/name/bulbasaur")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("bulbasaur"));
    }

    @Test
    void givenRemoteApiCall_whenCallByANotFoundPokemonId_thenStatusCode404() {
        given().when()
                .get("http://localhost:8080/api/pokemon/pokeapi/100000")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    void givenRemoteApiCall_whenCallByANotFoundPokemonName_thenStatusCode404() {
        given().when()
                .get("http://localhost:8080/api/pokemon/pokeapi/name/blablabla")
                .then()
                .assertThat()
                .statusCode(404);
    }
}