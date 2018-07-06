package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleRegistrationBindingDto {

    @NotNull
    private String role;
}
