package com.alejandro.JPAexampleMtoM.repositories;

import com.alejandro.JPAexampleMtoM.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
