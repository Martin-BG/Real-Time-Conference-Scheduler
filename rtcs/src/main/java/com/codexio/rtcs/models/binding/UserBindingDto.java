package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserBindingDto {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;
}
