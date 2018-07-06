package com.codexio.rtcs.models.binding;

import com.codexio.rtcs.entities.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRegisterBindingDto {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private Role role;
}
