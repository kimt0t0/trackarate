package com.kimdev.trackarate.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdev.trackarate.dto.AnswerDto;
import com.kimdev.trackarate.services.AnswerService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody AnswerDto answerDto) {
        return ResponseEntity.ok(service.save(answerDto));
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<AnswerDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{likeId}")
    public ResponseEntity<AnswerDto> findById(
            @PathParam("likeId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{likeId}")
    public ResponseEntity<Void> delete(@PathParam("likeId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
