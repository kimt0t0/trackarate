package com.kimdev.trackarate.controllers;

import java.time.ZonedDateTime;
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
import com.kimdev.trackarate.enums.TrainingFeeling;
import com.kimdev.trackarate.enums.TrainingState;
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

    @GetMapping("/all/by-username")
    public ResponseEntity<List<TrainingSessionDto>> findAllByUserUsername(@RequestBody String username) {
        return ResponseEntity.ok(service.findAllByUserUsername(username));
    }

    @GetMapping("/all/by-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByUserId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @GetMapping("/all/by-datetime")
    public ResponseEntity<List<TrainingSessionDto>> findAllByDatetime(@RequestBody ZonedDateTime datetime) {
        return ResponseEntity.ok(service.findAllByDatetime(datetime));
    }

    @GetMapping("/all/by-datetime-and-user")
    public ResponseEntity<List<TrainingSessionDto>> findAllByDatetimeAndUser(@RequestBody ZonedDateTime datetime,
            @RequestBody UUID userId) {
        return ResponseEntity.ok(service.findAllByDatetimeAndUserId(datetime, userId));
    }

    @GetMapping("/all/public/by-datetime-and-user")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByDatetimeAndUser(@RequestBody ZonedDateTime datetime,
            @RequestBody UUID userId) {
        return ResponseEntity.ok(service.findAllPublicByDatetimeAndUserId(datetime, userId));
    }

    @GetMapping("/all/by-date-before")
    public ResponseEntity<List<TrainingSessionDto>> findAllBefore(@RequestBody ZonedDateTime datetime) {
        return ResponseEntity.ok(service.findAllByDatetimeBefore(datetime));
    }

    @GetMapping("/all/by-date-after")
    public ResponseEntity<List<TrainingSessionDto>> findAllAfter(@RequestBody ZonedDateTime datetime) {
        return ResponseEntity.ok(service.findAllByDatetimeBefore(datetime));
    }

    @GetMapping("/all/by-type-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTypeId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllBySessionTypesId(id));
    }

    @GetMapping("/all/by-type-name")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTypeName(@RequestBody String name) {
        return ResponseEntity.ok(service.findAllBySessionTypesName(name));
    }

    @GetMapping("/all/public/by-type-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTypeId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicBySessionTypesId(id));
    }

    @GetMapping("/all/public/by-type-name")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTypeName(@RequestBody String name) {
        return ResponseEntity.ok(service.findAllPublicBySessionTypesName(name));
    }

    @GetMapping("/all/name-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByNameAndUserId(@RequestBody String name,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByNameAndUserId(name, id));
    }

    @GetMapping("/all/public/name-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByNameAndUserId(@RequestBody String name,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicByNameAndUserId(name, id));
    }

    @GetMapping("/all/by-program-name")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsName(@RequestBody String name) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsName(name));
    }

    @GetMapping("/all/public/by-program-name")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsName(@RequestBody String name) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsName(name));
    }

    @GetMapping("/all/by-program-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsId(id));
    }

    @GetMapping("/all/public/by-program-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsId(id));
    }

    @GetMapping("/all/by-exercise-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByExercisesId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByExercisesId(id));
    }

    @GetMapping("/all/public/by-exercise-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByExercisesId(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicByExercisesId(id));
    }

    @GetMapping("/all/by-exercise-title")
    public ResponseEntity<List<TrainingSessionDto>> findAllByExercisesTitle(@RequestBody String title) {
        return ResponseEntity.ok(service.findAllByExercisesTitle(title));
    }

    @GetMapping("/all/public/by-exercise-title")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByExercisesTitle(@RequestBody String title) {
        return ResponseEntity.ok(service.findAllPublicByExercisesTitle(title));
    }

    @GetMapping("/all/by-state")
    public ResponseEntity<List<TrainingSessionDto>> findAllByState(@RequestBody TrainingState state) {
        return ResponseEntity.ok(service.findAllByState(state));
    }

    @GetMapping("/all/public/by-state")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByState(@RequestBody TrainingState state) {
        return ResponseEntity.ok(service.findAllPublicByState(state));
    }

    @GetMapping("/all/by-state-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByStateAndUserId(@RequestBody TrainingState state,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByStateAndUserId(state, id));
    }

    @GetMapping("/all/public/by-state-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByStateAndUserId(@RequestBody TrainingState state,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicByStateAndUserId(state, id));
    }

    @GetMapping("/all/public/by-program-name-and-state")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsNameAndState(
            @RequestBody String name, @RequestBody TrainingState state) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsNameAndState(name, state));
    }

    @GetMapping("/all/by-program-name-and-state")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsNameAndState(
            @RequestBody String name, @RequestBody TrainingState state) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsNameAndState(name, state));
    }

    @GetMapping("/all/by-program-name-and-state-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsNameAndStateAndUserId(
            @RequestBody String name, @RequestBody TrainingState state, UUID id) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsNameAndStateAndUserId(name, state, id));
    }

    @GetMapping("/all/public/by-program-name-and-state-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsNameAndStateAndUserId(
            @RequestBody String name, @RequestBody TrainingState state, UUID id) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsNameAndStateAndUserId(name, state, id));
    }

    @GetMapping("/all/by-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllByFeeling(@RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllByFeeling(feeling));
    }

    @GetMapping("/all/public/by-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByFeeling(@RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllPublicByFeeling(feeling));
    }

    @GetMapping("/all/by-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByFeelingAndUserId(@RequestBody TrainingFeeling feeling,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByFeelingAndUserId(feeling, id));
    }

    @GetMapping("/all/public/by-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByFeelingAndUserId(
            @RequestBody TrainingFeeling feeling,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicByFeelingAndUserId(feeling, id));
    }

    @GetMapping("/all/public/by-program-name-and-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsNameAndFeeling(
            @RequestBody String name, @RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsNameAndFeeling(name, feeling));
    }

    @GetMapping("/all/by-program-name-and-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsNameAndFeeling(
            @RequestBody String name, @RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsNameAndFeeling(name, feeling));
    }

    @GetMapping("/all/by-program-name-and-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsNameAndFeelingAndUserId(
            @RequestBody String name, @RequestBody TrainingFeeling feeling, UUID id) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsNameAndFeelingAndUserId(name, feeling, id));
    }

    @GetMapping("/all/public/by-program-name-and-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsNameAndFeelingAndUserId(
            @RequestBody String name, @RequestBody TrainingFeeling feeling, UUID id) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsNameAndFeelingAndUserId(name, feeling, id));
    }

    @GetMapping("/all/by-state-and-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllByStateAndFeeling(@RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllByStateAndFeeling(state, feeling));
    }

    @GetMapping("/all/public/by-state-and-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByStateAndFeeling(@RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllPublicByStateAndFeeling(state, feeling));
    }

    @GetMapping("/all/by-state-and-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByStateAndFeelingAndUserId(@RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling, @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllByStateAndFeelingAndUserId(state, feeling, id));
    }

    @GetMapping("/all/public/by-state-and-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByStateAndFeelingAndUserId(
            @RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling, @RequestBody UUID id) {
        return ResponseEntity.ok(service.findAllPublicByStateAndFeelingAndUserId(state, feeling, id));
    }

    @GetMapping("/all/by-program-name-and-state-and-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsNameAndStateAndFeeling(
            @RequestBody String name, @RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllByTrainingProgramsNameAndStateAndFeeling(name, state, feeling));
    }

    @GetMapping("/all/public/by-program-name-and-state-and-feeling")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsNameAndStateAndFeeling(
            @RequestBody String name, @RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling) {
        return ResponseEntity.ok(service.findAllPublicByTrainingProgramsNameAndStateAndFeeling(name, state, feeling));
    }

    @GetMapping("/all/by-program-name-and-state-and-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllByTrainingProgramsNameAndStateAndFeelingAndUserId(
            @RequestBody String name, @RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling, @RequestBody UUID id) {
        return ResponseEntity
                .ok(service.findAllByTrainingProgramsNameAndStateAndFeelingAndUserId(name, state, feeling, id));
    }

    @GetMapping("/all/public/by-program-name-and-state-and-feeling-and-user-id")
    public ResponseEntity<List<TrainingSessionDto>> findAllPublicByTrainingProgramsNameAndStateAndFeelingAndUserId(
            @RequestBody String name, @RequestBody TrainingState state,
            @RequestBody TrainingFeeling feeling, @RequestBody UUID id) {
        return ResponseEntity
                .ok(service.findAllPublicByTrainingProgramsNameAndStateAndFeelingAndUserId(name, state, feeling,
                        id));
    }

    // GET ONE
    @GetMapping("/one")
    public ResponseEntity<TrainingSessionDto> findById(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/one/public")
    public ResponseEntity<TrainingSessionDto> findOnePublicById(@RequestBody UUID id) {
        return ResponseEntity.ok(service.findOnePublicById(id));
    }

    @GetMapping("/one/by-name-and-user-id")
    public ResponseEntity<TrainingSessionDto> findOneByNameAndUserId(@RequestBody String name, @RequestBody UUID id) {
        return ResponseEntity.ok(service.findOneByNameAndUserId(name, id));
    }

    @GetMapping("/one/public/by-name-and-user-id")
    public ResponseEntity<TrainingSessionDto> findOnePublicByNameAndUserId(@RequestBody String name,
            @RequestBody UUID id) {
        return ResponseEntity.ok(service.findOnePublicByNameAndUserId(name, id));
    }

    // DELETE
    @DeleteMapping("/delete/{sessionId}")
    public ResponseEntity<Void> delete(
            @PathVariable("sessionId") UUID id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
