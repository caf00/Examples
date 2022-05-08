package com.alejandro.JPAexampleMtoM.services.contract;

import com.alejandro.JPAexampleMtoM.dtos.actor.ActorDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.CreateActorDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.ListMoviesFromActorDto;

import java.util.List;

public interface ActorService {
    List<ActorDto> getActors();
    ActorDto save(CreateActorDto createActorDto);
    ActorDto findById(Integer id);
    void delete(Integer id);
    ListMoviesFromActorDto getMoviesFromActor(Integer id);
}
