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

import com.kimdev.trackarate.dto.TrainingSessionDto;
import com.kimdev.trackarate.services.TrainingSessionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class TrainingSessionController {

    private final TrainingSessionService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody TrainingSessionDto sessionDto) {
        return ResponseEntity.ok(service.save(sessionDto));
    }

    // GET MANY
    @GetMapping("/all")
    public ResponseEntity<List<TrainingSessionDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/all/user/{userId}")
    public ResponseEntity<List<TrainingSessionDto>> findAllByUserId(@PathVariable("userId") UUID id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    // GET ONE
    @GetMapping("/one/id/{sessionId}")
    public ResponseEntity<TrainingSessionDto> findById(@PathVariable("sessionId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{sessionId}")
    public ResponseEntity<Void> delete(
            @PathVariable("sessionId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
