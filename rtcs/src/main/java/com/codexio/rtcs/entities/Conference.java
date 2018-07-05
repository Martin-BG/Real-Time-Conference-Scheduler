package com.codexio.rtcs.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

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