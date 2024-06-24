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

import com.kimdev.trackarate.dto.MediaDto;
import com.kimdev.trackarate.services.MediaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody MediaDto mediaDto) {
        return ResponseEntity.ok(service.save(mediaDto));
    }

    // GET MANY
    @GetMapping("/all")
    public ResponseEntity<List<MediaDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{mediaId}")
    public ResponseEntity<MediaDto> findById(
            @PathVariable("mediaId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{mediaId}")
    public ResponseEntity<Void> delete(
            @PathVariable("mediaId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
