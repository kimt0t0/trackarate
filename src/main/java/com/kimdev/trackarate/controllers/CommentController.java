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

import com.kimdev.trackarate.dto.CommentDto;
import com.kimdev.trackarate.services.CommentService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(service.save(commentDto));
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<CommentDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{likeId}")
    public ResponseEntity<CommentDto> findById(
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
