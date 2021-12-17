package com.alejandro.testupdate.core.usecase;

import com.alejandro.testupdate.core.domain.Client;
import com.alejandro.testupdate.core.domain.ClientRepository;

public class CreateClientUseCaseImpl implements CreateClientUseCase{

    private final ClientRepository clientRepository;

    public CreateClientUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client execute(Client client) {
        return this.clientRepository.saveOrUpdateClient(client);
    }
}
