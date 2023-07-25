package com.mypractice.inmemory.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTest {
    private final TestRestTemplate restTemplate;
    HttpHeaders headers;
    @LocalServerPort
    private int port;
    @Autowired
    TestControllerTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        var accessToken ="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJzdWIiOiJhZG1pbiIsImlhdCI6MTY5MDMxMjQ1NCwiZXhwIjoyMDA1OTMxNjU0fQ.HONb6lg05UAbl-UXILys0YVsgLJYjciH3vMqJpQqthE";
        headers.set("Authorization", "Bearer " + accessToken);
    }

    @Test
    void sayHello(){
        var resMsg = "Welcome Nasruddin khan!";
        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
        final var targetUrl = fromUriString("http://localhost:" + port + "/msg/v1/")
                .path("Nasruddin khan")
                .build()
                .encode()
                .toUri();
        System.out.println(targetUrl);
       final var response = restTemplate.exchange(
                targetUrl,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Map<String, String>>() {
                });

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(resMsg, response.getBody().get("msg"));
    }
}