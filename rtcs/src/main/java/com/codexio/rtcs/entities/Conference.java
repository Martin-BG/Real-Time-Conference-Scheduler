package com.codexio.rtcs.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "conferences")
public class Conference {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(
            mappedBy = "conference",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE
    )
    private Set<Session> sessions = new HashSet<>();

    @OneToMany(
            mappedBy = "conference",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE
    )
    private Set<Hall> halls = new HashSet<>();

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner.getName() +
                ", description='" + (
                (description != null && description.length() > 20)
                        ? description.substring(0, 17) + "..."
                        : description) + '\'' +
                ", address=" + address +
                ", startDate=" + startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                ", endDate=" + endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                ", sessions=" + sessions.size() +
                '}';
    }
}
