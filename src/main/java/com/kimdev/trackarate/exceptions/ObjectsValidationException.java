package com.kimdev.trackarate.exceptions;

import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ObjectsValidationException extends RuntimeException {

    @Getter
    private final Set<String> violations;

    @Getter
    private final String violationSource;

}
