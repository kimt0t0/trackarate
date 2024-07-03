package com.kimdev.trackarate.services;

import java.util.List;

import com.kimdev.trackarate.dto.RoleDto;

public interface RoleService extends AbstractService<RoleDto> {

    List<RoleDto> findAllByName(String name);

    RoleDto findOneByName(String name);
}
