package com.codexio.rtcs.services;

import com.codexio.rtcs.models.binding.RoleRegistrationBindingDto;
import com.codexio.rtcs.models.view.RoleViewDto;

public interface RoleService {

    RoleViewDto create(RoleRegistrationBindingDto roleRegistrationBindingDto);

    RoleViewDto getById(Long id);
}
