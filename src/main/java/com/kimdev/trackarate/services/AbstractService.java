package com.kimdev.trackarate.services;

import java.util.List;
import java.util.UUID;

public interface AbstractService<T> {

    UUID save(T dto);

    List<T> findAll();

    T findById(UUID id);

    void delete(UUID id);

}
