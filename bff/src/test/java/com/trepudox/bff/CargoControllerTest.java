package com.trepudox.bff;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class CargoControllerTest {

    @Test
    void testHelloEndpoint() {
        given().contentType(ContentType.JSON)
          .when().get("/hello/again")
          .then()
             .statusCode(200)
             .body(is("{\"message\": \"Hello World!\"}"));
    }

}