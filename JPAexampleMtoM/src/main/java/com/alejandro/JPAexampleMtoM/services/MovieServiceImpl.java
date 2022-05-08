package com.alejandro.JPAexampleMtoM.services;

import com.alejandro.JPAexampleMtoM.dtos.movie.*;
import com.alejandro.JPAexampleMtoM.entities.Actor;
import com.alejandro.JPAexampleMtoM.entities.Movie;
import com.alejandro.JPAexampleMtoM.exceptions.ResourceNotFoundException;
import com.alejandro.JPAexampleMtoM.repositories.ActorRepository;
import com.alejandro.JPAexampleMtoM.repositories.MovieRepository;
import com.alejandro.JPAexampleMtoM.services.contract.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<MovieDto> getMovies() {
        return this.movieRepository.findAll()
                .stream()
                .map(this::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDto save(CreateMovieDto createMovieDto) {
        Movie movie = this.createMovieDtoToMovie(createMovieDto);
        return this.movieToMovieDto(this.movieRepository.save(movie));
    }

    @Override
    public void delete(Integer id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public void addActors(ActorsToMovieDto actorsToMovieDto, Integer id) {
        Set<Actor> actors = actorsToMovieDto.getActors_id()
                .stream()
                .map(this::findActor).collect(Collectors.toSet());
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        movie.addActors(actors);
        this.movieRepository.save(movie);
    }


    @Override
    public void removeActors(ActorsToMovieDto actorsToMovieDto, Integer id) {
        Set<Actor> actors = actorsToMovieDto.getActors_id()
                .stream()
                .map(this::findActor).collect(Collectors.toSet());
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        movie.removeActors(actors);
        this.movieRepository.save(movie);
    }

    @Override
    public ListActorsFromMovieDto getActorsFromMovie(Integer id) {
        Movie movie = this.findMovie(id);
        List<String> actorsName = movie.getActors()
                .stream()
                .map(Actor::getName).collect(Collectors.toList());

        return this.listMoviesFromActorDto(movie.getName(), actorsName);
    }

    @Override
    public MovieDto findById(Integer id) {
        Movie movie = this.findMovie(id);
        return this.movieToMovieDto(movie);
    }

    private Actor findActor(Integer id) {
        return this.actorRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    private Movie findMovie(Integer id) {
        return this.movieRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    /*

        Mapping methods.

     */

    private ListActorsFromMovieDto listMoviesFromActorDto(String name, List<String> actorsName) {
        return new ListActorsFromMovieDto(name, actorsName);
    }

    private Movie createMovieDtoToMovie(CreateMovieDto createMovieDto) {
        Movie movie = new Movie();
        if (createMovieDto == null) return movie;
        movie.setName(createMovieDto.getName());
        return movie;

    }

    private MovieDto movieToMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        if (movie == null) return movieDto;
        movieDto.setId(movie.getId());
        movieDto.setName(movie.getName());
        return movieDto;
    }
}
