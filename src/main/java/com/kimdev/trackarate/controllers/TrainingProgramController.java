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

import com.kimdev.trackarate.dto.TrainingProgramDto;
import com.kimdev.trackarate.services.TrainingProgramService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
public class TrainingProgramController {

    private final TrainingProgramService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody TrainingProgramDto programDto) {
        return ResponseEntity.ok(service.save(programDto));
    }

    // GET MANY
    @GetMapping("/")
    public ResponseEntity<List<TrainingProgramDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{programId}")
    public ResponseEntity<TrainingProgramDto> findById(
            @PathVariable("programId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{programId}")
    public ResponseEntity<Void> delete(
            @PathVariable("programId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
