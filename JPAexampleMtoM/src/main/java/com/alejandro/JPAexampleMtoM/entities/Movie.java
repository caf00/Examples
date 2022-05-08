package com.alejandro.JPAexampleMtoM.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "movies")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();

    public void addActors(Set<Actor> actors) {
        this.actors.addAll(actors);
    }

    public void removeActors(Set<Actor> actors) {
        this.actors.removeAll(actors);
    }

    public void removeActor(Actor actor) {
        if (this.actors != null) this.actors.remove(actor);
    }
}
