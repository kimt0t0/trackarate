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

import com.kimdev.trackarate.dto.ExerciseDto;
import com.kimdev.trackarate.services.ExerciseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody ExerciseDto exerciseDto) {
        return ResponseEntity.ok(service.save(exerciseDto));
    }

    // GET MANY
    @GetMapping("/all")
    public ResponseEntity<List<ExerciseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{exerciseId}")
    public ResponseEntity<ExerciseDto> findById(
            @PathVariable("exerciseId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{exerciseId}")
    public ResponseEntity<Void> delete(
            @PathVariable("exerciseId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
