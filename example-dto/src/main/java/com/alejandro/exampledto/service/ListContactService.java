package com.alejandro.exampledto.service;

import com.alejandro.exampledto.service.dto.ContactDto;

import java.util.Collection;

public interface ListContactService {
    Collection<ContactDto> list();
}
