package com.alejandro.testupdate.core.useCase;

import com.alejandro.testupdate.core.domain.Client;

import java.util.List;

public interface GetAllClientsUseCase {
    List<Client> execute();
}
