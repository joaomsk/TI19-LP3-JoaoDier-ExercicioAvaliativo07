package br.fundatec.joaodier.finalproject.api.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class HealthCheckControllerIntegrationTest {

    @Test
    void givenRemoteApiCall_whenCallByHealthChecker_thenStatusCode200() {
        given()
                .when()
                .get("http://localhost:8080/api/health")
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo("Hey! I'm working sir."));
    }
}