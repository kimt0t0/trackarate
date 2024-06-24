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

import com.kimdev.trackarate.dto.RoleDto;
import com.kimdev.trackarate.services.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(service.save(roleDto));
    }

    // GET MANY
    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE

    @GetMapping("/one/{roleId}")
    public ResponseEntity<RoleDto> findById(
            @PathVariable("roleId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{roleId}")
    public ResponseEntity<Void> delete(
            @PathVariable("roleId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
