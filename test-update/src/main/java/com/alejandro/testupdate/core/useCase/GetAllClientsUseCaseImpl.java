package com.alejandro.testupdate.core.useCase;

import com.alejandro.testupdate.core.domain.Client;
import com.alejandro.testupdate.core.domain.ClientRepository;

import java.util.List;

public class GetAllClientsUseCaseImpl implements GetAllClientsUseCase{

    private final ClientRepository clientRepository;

    public GetAllClientsUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> execute() {
        return this.clientRepository.getAllClients();
    }
}
