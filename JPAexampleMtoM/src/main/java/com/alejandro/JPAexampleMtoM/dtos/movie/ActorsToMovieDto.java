package com.alejandro.JPAexampleMtoM.dtos.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActorsToMovieDto {
    private Set<Integer> actors_id;
}
