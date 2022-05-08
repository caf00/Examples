package com.alejandro.exampledto.service.impl;

import com.alejandro.exampledto.domain.entity.Contact;
import com.alejandro.exampledto.domain.ContactJpaRepository;
import com.alejandro.exampledto.service.dto.ContactDto;
import com.alejandro.exampledto.service.SaveContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveContactServiceImpl implements SaveContactService {

    private final ContactJpaRepository contactJpaRepository;

    @Autowired
    public SaveContactServiceImpl(ContactJpaRepository contactJpaRepository) {
        this.contactJpaRepository = contactJpaRepository;
    }

    @Override
    public void save(ContactDto contactDto) {
        contactJpaRepository.save(new Contact(
                null,
                contactDto.getName(),
                contactDto.getLastName(),
                contactDto.getAddress(),
                contactDto.getPhone()
        ));
    }
}
