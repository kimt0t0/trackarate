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

import com.kimdev.trackarate.dto.SettingsDto;
import com.kimdev.trackarate.services.SettingsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users/settings")
@RequiredArgsConstructor
public class SettingsController {

    private final SettingsService service;

    // SAVE
    // @PostMapping("/initialize/{userId}")
    // public ResponseEntity<UUID> initializeUserSettings(@PathVariable("userId")
    // UUID id) {
    // return ResponseEntity.ok(service.initializeUserSettings(id));
    // }

    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody SettingsDto settingsDto) {
        return ResponseEntity.ok(service.save(settingsDto));
    }

    // GET MANY
    @GetMapping("/all")
    public ResponseEntity<List<SettingsDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET ONE
    @GetMapping("/one/{settingsId}")
    public ResponseEntity<SettingsDto> findById(
            @PathVariable("settingsId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // DELETE
    @DeleteMapping("/delete/{settingsId}")
    public ResponseEntity<Void> delete(
            @PathVariable("settingsId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
