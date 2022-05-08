package com.alejandro.JPAexampleMtoM.controllers;

import com.alejandro.JPAexampleMtoM.dtos.MessageDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.ActorDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.CreateActorDto;
import com.alejandro.JPAexampleMtoM.dtos.actor.ListMoviesFromActorDto;
import com.alejandro.JPAexampleMtoM.services.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {

    @Autowired
    private ActorServiceImpl actorService;

    @GetMapping
    public ResponseEntity<List<ActorDto>> getAll() {
        return ResponseEntity.ok(this.actorService.getActors());
    }

    @GetMapping("{id}")
    public ResponseEntity<ActorDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.actorService.findById(id));
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<ListMoviesFromActorDto> getMoviesFromActor(@PathVariable Integer id) {
        return ResponseEntity.ok(this.actorService.getMoviesFromActor(id));
    }

    @PostMapping
    public ResponseEntity<ActorDto> save(@RequestBody CreateActorDto createActorDto) {
        return ResponseEntity.ok(this.actorService.save(createActorDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Integer id) {
        this.actorService.delete(id);
        return ResponseEntity.ok(new MessageDto("Actor deleted successfully."));
    }
}

