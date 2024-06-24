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

import com.kimdev.trackarate.dto.TypeDto;
import com.kimdev.trackarate.services.TypeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/types")
@RequiredArgsConstructor
public class TypeController {

    private TypeService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody TypeDto typeDto) {
        return ResponseEntity.ok(service.save(typeDto));
    }

    // GET MANY
    @GetMapping("/")
    public ResponseEntity<List<TypeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/id/{typeId}")
    public ResponseEntity<TypeDto> getMethodName(@PathVariable("typeId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{typeId}")
    public ResponseEntity<Void> delete(@PathVariable("typeId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
