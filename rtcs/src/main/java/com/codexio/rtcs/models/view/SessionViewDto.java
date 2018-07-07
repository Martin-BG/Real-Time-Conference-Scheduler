package com.codexio.rtcs.models.view;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionViewDto {

    private String id;

    private String name;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String speakerName;

    private String speakerDescription;

    private String speakerPhotoLink;

    private String conferenceName;

    private String conferenceId;

    private String hallName;

    private String hallId;

    private Integer attendancesCount;
}
