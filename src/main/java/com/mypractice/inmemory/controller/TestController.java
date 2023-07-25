package com.mypractice.inmemory.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/msg/v1")
@SecurityRequirement(name = "in-memory")
public class TestController {

    @GetMapping("/{name}")
    public ResponseEntity<Map<String, String>> sayHello(@PathVariable String name){
       return ResponseEntity.ok(Map.of("msg", String.format("Welcome %s!", name)));
    }

}
