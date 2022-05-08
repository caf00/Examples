package com.alejandro.JPAexampleMtoM.services.contract;

import com.alejandro.JPAexampleMtoM.dtos.movie.ActorsToMovieDto;
import com.alejandro.JPAexampleMtoM.dtos.movie.CreateMovieDto;
import com.alejandro.JPAexampleMtoM.dtos.movie.ListActorsFromMovieDto;
import com.alejandro.JPAexampleMtoM.dtos.movie.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getMovies();
    MovieDto save(CreateMovieDto createMovieDto);
    void delete(Integer id);
    void addActors(ActorsToMovieDto actorsToMovieDto, Integer id);
    void removeActors(ActorsToMovieDto actorsToMovieDto, Integer id);
    ListActorsFromMovieDto getActorsFromMovie(Integer id);
    MovieDto findById(Integer id);
}
