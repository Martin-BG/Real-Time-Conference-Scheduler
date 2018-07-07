package com.codexio.rtcs.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2048)
    private String description;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "conference_id", nullable = false)
    private Conference conference;

    @OneToMany(
            mappedBy = "hall",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE
    )
    private Set<Session> sessions = new HashSet<>();

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + (
                (description != null && description.length() > 20)
                        ? description.substring(0, 17) + "..."
                        : description) + '\'' +
                ", capacity=" + capacity +
                ", conference=" + conference.getName() +
                ", sessions=" + sessions.size() +
                '}';
    }
}
