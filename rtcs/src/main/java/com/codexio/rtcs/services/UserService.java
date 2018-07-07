package com.codexio.rtcs.services;

import com.codexio.rtcs.models.binding.UserRegisterBindingDto;
import com.codexio.rtcs.models.view.UserViewDto;

public interface UserService {

    UserViewDto create(UserRegisterBindingDto userRegisterBindingDto);

    UserViewDto getByEmail(String email);

    UserViewDto getById(String id);
}
