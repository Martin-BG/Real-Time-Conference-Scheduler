package com.codexio.rtcs.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @Column(nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String speakerName;

    @Column(length = 2048)
    private String speakerDescription;

    @Column
    private String speakerPhotoLink;

    @ManyToOne
    @JoinColumn(name = "conference_id", nullable = false)
    private Conference conference;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "sessions_users",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> attendances = new HashSet<>();

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hall=" + hall.getName() +
                ", description='" + (
                (description != null && description.length() > 20)
                        ? description.substring(0, 17) + "..."
                        : description) + '\'' +
                ", conference=" + conference.getName() +
                ", startTime=" + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                ", endTime=" + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                ", speakerName='" + speakerName + '\'' +
                ", speakerDescription='" + (
                (speakerDescription != null && speakerDescription.length() > 20)
                        ? speakerDescription.substring(0, 17) + "..."
                        : speakerDescription) + '\'' +
                ", speakerPhotoLink='" + speakerPhotoLink + '\'' +
                ", attendances=" + attendances.size() +
                '}';
    }
}
