package com.codexio.rtcs.models.binding;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ConferenceCreateBindingDto {

    private String userEmail;

    @NotBlank
    @Size(max = 255)
    private String name;

    @Size(max = 2048)
    private String description;

    @NotBlank
    @Size(max = 255)
    private String address;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
