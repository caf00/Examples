package com.alejandro.relationshipexample.repositories;

import com.alejandro.relationshipexample.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
}
