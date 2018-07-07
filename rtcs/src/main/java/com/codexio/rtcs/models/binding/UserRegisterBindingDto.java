package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterBindingDto {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;
}
