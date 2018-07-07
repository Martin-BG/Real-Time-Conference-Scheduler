package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginBindingDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
