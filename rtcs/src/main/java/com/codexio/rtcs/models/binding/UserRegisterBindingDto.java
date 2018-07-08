package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegisterBindingDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 255)
    private String password;

    @NotBlank
    @Size(max = 255)
    private String confirmPassword;
}
