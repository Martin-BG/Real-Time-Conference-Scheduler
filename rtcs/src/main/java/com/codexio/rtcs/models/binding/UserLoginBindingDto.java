package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginBindingDto {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
