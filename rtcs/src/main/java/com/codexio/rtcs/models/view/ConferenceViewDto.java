package com.codexio.rtcs.models.view;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConferenceViewDto {

    private String userEmail;

    private String id;

    private String name;

    private String description;

    private String address;

    private LocalDate startDate;

    private LocalDate endDate;
}
