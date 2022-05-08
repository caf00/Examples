package com.alejandro.JPAexampleMtoM.repositories;

import com.alejandro.JPAexampleMtoM.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
