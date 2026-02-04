package com.example.space.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.space.service.IngestionService;


@RestController
@RequestMapping("/api/space")
public class AcceptController {

    private final IngestionService ingestionService;

    public AcceptController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @GetMapping("/accept")
    public ResponseEntity<String> accept(
            @RequestParam String id,
            @RequestParam(required = false) String endpoint) {

        try {
            ingestionService.process(id, endpoint);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("failed");
        }
    }
}