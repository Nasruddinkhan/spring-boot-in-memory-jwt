package com.mypractice.inmemory.controller;

import com.mypractice.inmemory.dto.AuthRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

    @LocalServerPort
    private int port;
    private final TestRestTemplate restTemplate;
    HttpHeaders headers;

    @Autowired
    AuthControllerTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    @Test
    void authRequest() throws Exception {
        final var request = new AuthRequestDto("admin", "admin");
        final var requestEntity = new HttpEntity<>(request, headers);
        final URI targetUrl = fromUriString("http://localhost:" + port + "/auth/v1/login")
                .build()
                .encode()
                .toUri();
        var response = restTemplate.exchange(
                targetUrl,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Map<String, String>>() {
                });

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody().get("token"));
    }

    @AfterEach
    void tearDown() {
    }
}