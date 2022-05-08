package com.alejandro.JPAexampleMtoM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "actors")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();

    public void addMovies(Set<Movie> movies) {
        this.movies.addAll(movies);
    }

    public void removeMovies(Set<Movie> movies) {
        if (this.movies != null) this.movies.removeAll(movies);
    }
}
