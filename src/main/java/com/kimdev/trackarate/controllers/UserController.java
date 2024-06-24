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

import com.kimdev.trackarate.dto.UserDto;
import com.kimdev.trackarate.services.UserService;

import lombok.RequiredArgsConstructor;

// Errors are directly handled by global exceptions handler
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // SAVE
    @PostMapping("/")
    public ResponseEntity<UUID> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.save(userDto));
    }

    // GET MANY
    // all
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/public")
    public ResponseEntity<List<UserDto>> findAllPublic() {
        return ResponseEntity.ok(service.findAllPublicUsers());
    }

    // username
    @GetMapping("/all/username/{username}")
    public ResponseEntity<List<UserDto>> findAllByUsername(
            @PathVariable String username) {
        return ResponseEntity.ok(service.findAllPublicByUsername(username));
    }

    @GetMapping("/all/public/username/{username}")
    public ResponseEntity<List<UserDto>> findAllPublicByUsername(
            @PathVariable String username) {
        return ResponseEntity.ok(service.findAllPublicByUsername(username));
    }

    // email
    @GetMapping("/all/email/{email}")
    public ResponseEntity<List<UserDto>> findAllByEmail(
            @PathVariable String email) {
        return ResponseEntity.ok(service.findAllByEmail(email));
    }

    @GetMapping("/all/public/email/{email}")
    public ResponseEntity<List<UserDto>> findAllPublicByEmail(
            @PathVariable String email) {
        return ResponseEntity.ok(service.findAllPublicByEmail(email));
    }

    // role
    @GetMapping("/all/role/{role}")
    public ResponseEntity<List<UserDto>> findAllByRole(
            @PathVariable String role) {
        return ResponseEntity.ok(service.findAllByRole(role));
    }

    @GetMapping("/all/public/role/{role}")
    public ResponseEntity<List<UserDto>> findAllPublicByRole(
            @PathVariable String role) {
        return ResponseEntity.ok(service.findAllPublicByRole(role));
    }

    // goals
    @GetMapping("/all/goals/{goals}")
    public ResponseEntity<List<UserDto>> findAllByGoals(
            @PathVariable String goals) {
        return ResponseEntity.ok(service.findAllByGoals(goals));
    }

    @GetMapping("/all/public/goals/{goals}")
    public ResponseEntity<List<UserDto>> findAllPublicByGoals(
            @PathVariable String goals) {
        return ResponseEntity.ok(service.findAllPublicByGoals(goals));
    }

    // sensei id
    @GetMapping("/all/sensei-id/{senseiId}")
    public ResponseEntity<List<UserDto>> findAllBySenseiId(
            @PathVariable("senseiId") UUID id) {
        return ResponseEntity.ok(service.findAllBySenseiId(id));
    }

    @GetMapping("/all/public/sensei-id/{senseiId}")
    public ResponseEntity<List<UserDto>> findAllPublicBySenseiId(
            @PathVariable("senseiId") UUID id) {
        return ResponseEntity.ok(service.findAllPublicBySenseiId(id));
    }

    // sensei username
    @GetMapping("/all/sensei-username/{username}")
    public ResponseEntity<List<UserDto>> findAllBySenseiUsername(
            @PathVariable("username") String username) {
        return ResponseEntity.ok(service.findAllBySenseiUsername(username));
    }

    @GetMapping("/all/public/sensei-username/{username}")
    public ResponseEntity<List<UserDto>> findAllPublicBySenseiUsername(
            @PathVariable("username") String username) {
        return ResponseEntity.ok(service.findAllPublicBySenseiUsername(username));
    }

    // student id
    @GetMapping("/all/student-id/{studentId}")
    public ResponseEntity<List<UserDto>> findAllByStudentId(
            @PathVariable("studentId") UUID id) {
        return ResponseEntity.ok(service.findAllByStudentId(id));
    }

    @GetMapping("/all/public/student-id/{studentId}")
    public ResponseEntity<List<UserDto>> findAllPublicByStudentId(
            @PathVariable("studentId") UUID id) {
        return ResponseEntity.ok(service.findAllPublicByStudentId(id));
    }

    // student username
    @GetMapping("/all/student-username/{username}")
    public ResponseEntity<List<UserDto>> findAllByStudentUsername(
            @PathVariable String username) {
        return ResponseEntity.ok(service.findAllByStudentUsername(username));
    }

    @GetMapping("/all/public/student-username/{username}")
    public ResponseEntity<List<UserDto>> findAllPublicByStudentUsername(
            @PathVariable String username) {
        return ResponseEntity.ok(service.findAllPublicByStudentUsername(username));
    }

    // contact id
    @GetMapping("/all/contact-id/{contactId}")
    public ResponseEntity<List<UserDto>> findAllByContactId(
            @PathVariable("contactId") UUID id) {
        return ResponseEntity.ok(service.findAllByContactId(id));
    }

    @GetMapping("/all/public/contact-id/{contactId}")
    public ResponseEntity<List<UserDto>> findAllPublicByContactId(
            @PathVariable("contactId") UUID id) {
        return ResponseEntity.ok(service.findAllPublicByContactId(id));
    }

    // contact username
    @GetMapping("/all/contact-username/{username}")
    public ResponseEntity<List<UserDto>> findAllByContactUsername(
            @PathVariable String username) {
        return ResponseEntity.ok(service.findAllByContactUsername(username));
    }

    @GetMapping("/all/public/contact-username/{username}")
    public ResponseEntity<List<UserDto>> findAllPublicByContactUsername(
            @PathVariable String username) {
        return ResponseEntity.ok(service.findAllPublicByContactUsername(username));
    }

    // GET ONE
    // id
    @GetMapping("/one/id/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable("userId") UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/one/public/id/{userId}")
    public ResponseEntity<UserDto> findOnePublicById(@PathVariable("userId") UUID id) {
        return ResponseEntity.ok(service.findOnePublicById(id));
    }

    // username
    @GetMapping("one/username/{username}")
    public ResponseEntity<UserDto> findOneByUserName(@PathVariable String username) {
        return ResponseEntity.ok(service.findOneByUsername(username));
    }

    @GetMapping("one/public/username/{username}")
    public ResponseEntity<UserDto> findOnePublicByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.findOnePublicByUsername(username));
    }

    // email
    @GetMapping("/one/email/{email}")
    public ResponseEntity<UserDto> findOneByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findOneByEmail(email));
    }

    @GetMapping("/one/public/email/{email}")
    public ResponseEntity<UserDto> findOnePublicByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findOnePublicByEmail(email));
    }

    // DELETE
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    // Other example: structure for a search with multiple parameters
    // @GetMapping("/search")
    // public String search(
    // @RequestParam String username,
    // @RequestParam String beltOrGrade) {
    // return new String();
    // }

}
