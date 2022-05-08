package com.alejandro.JPAexampleMtoM.services;

import com.alejandro.JPAexampleMtoM.dtos.actor.ActorDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.CreateActorDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.ListMoviesFromActorDto;
import com.alejandro.JPAexampleMtoM.entities.Actor;
import com.alejandro.JPAexampleMtoM.entities.Movie;
import com.alejandro.JPAexampleMtoM.exceptions.ResourceNotFoundException;
import com.alejandro.JPAexampleMtoM.repositories.ActorRepository;
import com.alejandro.JPAexampleMtoM.repositories.MovieRepository;
import com.alejandro.JPAexampleMtoM.services.contract.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<ActorDto> getActors() {
        return this.actorRepository.findAll()
                .stream()
                .map(this::actorToActorDto).collect(Collectors.toList());
    }

    @Override
    public ActorDto save(CreateActorDto createActorDto) {
        Actor actor = this.createActorDtoToActor(createActorDto);
        return this.actorToActorDto(this.actorRepository.save(actor));
    }

    @Override
    public ActorDto findById(Integer id) {
        Actor actor = this.findActor(id);
        return this.actorToActorDto(actor);
    }

    @Override
    public void delete(Integer id) {
        this.actorRepository.deleteById(id);
    }

    @Override
    public ListMoviesFromActorDto getMoviesFromActor(Integer id) {
        Actor actor = this.findActor(id);
        List<String> moviesName = actor.getMovies()
                .stream()
                .map(Movie::getName).collect(Collectors.toList());
        return this.listMoviesFromActorDto(actor.getName(), moviesName);
    }

    private Actor findActor(Integer id) {
        return this.actorRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    /*

        Mapping methods.

     */

    private ListMoviesFromActorDto listMoviesFromActorDto(String name, List<String> moviesName) {
        return new ListMoviesFromActorDto(name, moviesName);
    }

    private Actor createActorDtoToActor(CreateActorDto createActorDto) {
        Actor actor = new Actor();
        if (createActorDto == null) return actor;
        actor.setName(createActorDto.getName());
        return actor;

    }

    private ActorDto actorToActorDto(Actor actor) {
        ActorDto actorDto = new ActorDto();
        if (actor == null) return actorDto;
        actorDto.setId(actor.getId());
        actorDto.setName(actor.getName());
        return actorDto;
    }
}
