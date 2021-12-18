package com.alejandro.testupdate.core.usecase;

import com.alejandro.testupdate.core.domain.Client;
import com.alejandro.testupdate.core.domain.ClientRepository;

public class UpdateClientUseCaseImpl implements UpdateClientUseCase{

    private final ClientRepository clientRepository;

    public UpdateClientUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client execute(Client client) {
        var clientToUpdate = this.clientRepository.findClientById(client.getId())
                .orElseThrow(()->new RuntimeException("Client not exist."));
        clientToUpdate.updateFrom(client);
        return this.clientRepository.saveOrUpdateClient(clientToUpdate);
    }
}
