package com.alejandro.exampledto.domain;

import com.alejandro.exampledto.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactJpaRepository extends JpaRepository<Contact, Integer> {
}
