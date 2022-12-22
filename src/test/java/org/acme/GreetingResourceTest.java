package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {
    @InjectMock
    GreetingService greetingService;


    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testHelloGreetingEndpointWithMock() {
        Mockito.when(greetingService.greeting("kenobi"))
                .thenReturn("Hello There... General KENOBI");

        given()
                .when().get("/hello/greeting/kenobi")
                .then()
                .statusCode(200)
                .body(is("Hello There... General KENOBI"));
    }

}