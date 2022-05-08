package com.alejandro.JPAexampleMtoM.controllers;
import com.alejandro.JPAexampleMtoM.dtos.MessageDto;
import com.alejandro.JPAexampleMtoM.dtos.movie.*;
import com.alejandro.JPAexampleMtoM.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getMovies());
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.movieService.findById(id));
    }

    @GetMapping("{id}/actors")
    public ResponseEntity<ListActorsFromMovieDto> getActorsFromMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(this.movieService.getActorsFromMovie(id));
    }

    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody CreateMovieDto createMovieDto) {
        return ResponseEntity.ok(this.movieService.save(createMovieDto));
    }

    @PostMapping("{id}/add-actors")
    public ResponseEntity<MessageDto> addActors(
            @RequestBody ActorsToMovieDto actorsToMovieDto,
            @PathVariable Integer id) {
        this.movieService.addActors(actorsToMovieDto, id);
        return ResponseEntity.ok(new MessageDto("Actors added successfully."));
    }

    @DeleteMapping("{id}/remove-actors")
    public ResponseEntity<MessageDto> removeActors(
            @RequestBody ActorsToMovieDto actorsToMovieDto,
            @PathVariable Integer id) {
        this.movieService.removeActors(actorsToMovieDto, id);
        return ResponseEntity.ok(new MessageDto("Actors removed successfully."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Integer id) {
        this.movieService.delete(id);
        return ResponseEntity.ok(new MessageDto("Movie deleted successfully."));
    }
}
