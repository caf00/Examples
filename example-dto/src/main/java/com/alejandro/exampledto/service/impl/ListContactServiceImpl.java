package com.alejandro.exampledto.service.impl;

import com.alejandro.exampledto.domain.ContactJpaRepository;
import com.alejandro.exampledto.service.dto.ContactDto;
import com.alejandro.exampledto.service.ListContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ListContactServiceImpl implements ListContactService {

    private final ContactJpaRepository contactJpaRepository;

    @Autowired
    public ListContactServiceImpl(ContactJpaRepository contactJpaRepository) {
        this.contactJpaRepository = contactJpaRepository;
    }

    @Override
    public Collection<ContactDto> list() {
        return contactJpaRepository
                .findAll()
                .stream()
                .map(c->new ContactDto(
                        c.getId(),
                        c.getName(),
                        c.getLastName(),
                        c.getAddress(),
                        c.getPhone()
                ))
                .collect(Collectors.toList());
    }
}
