package com.alejandro.handlerInterceptorExample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class MyController {
    @GetMapping
    public ResponseEntity<String> greet(@RequestParam(required = false, defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello "+name+"!!!");
    }
}
