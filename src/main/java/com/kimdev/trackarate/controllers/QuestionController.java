package com.kimdev.trackarate.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdev.trackarate.dto.QuestionDto;
import com.kimdev.trackarate.services.QuestionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody QuestionDto questionDto) {
        return ResponseEntity.ok(service.save(questionDto));
    }

    // GET MANY
    @GetMapping("/all")
    public ResponseEntity<List<QuestionDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{questionId}")
    public ResponseEntity<QuestionDto> findById(
            @PathVariable("questionId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<Void> delete(
            @PathVariable("questionId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
