package com.codexio.rtcs.models.binding;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ConferenceCreateBindingDto {

    private String userId;

    @NotBlank
    private String name;

    @Size(max = 2048)
    private String description;

    @NotBlank
    private String address;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
}
