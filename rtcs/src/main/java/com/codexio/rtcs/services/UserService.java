package com.codexio.rtcs.services;

import com.codexio.rtcs.entities.Role;
import com.codexio.rtcs.models.binding.UserLoginBindingDto;
import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.models.view.UserViewDto;

public interface UserService {

    UserViewDto create(UserRegisterBindingDto userRegisterBindingDto);

    UserViewDto getByEmail(String email);

    UserViewDto getById(String id);

    Boolean isPasswordValid(UserLoginBindingDto userLoginBindingDto);

    Role setRole(UserRegisterBindingDto userRegisterBindingDto);
}
