package com.alejandro.JPAexampleMtoM.dtos.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListActorsFromMovieDto {
    private String movie_name;
    private List<String> actors_name;
}
