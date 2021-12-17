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
        Client clientToUpdate = this.clientRepository.findClientById(client.getId())
                .orElseThrow(()->new RuntimeException("Client not exist."));
        System.out.println(client.toString());
        System.out.println(clientToUpdate.toString());
        clientToUpdate.updateFrom(client);
        System.out.println(clientToUpdate.toString());
        return this.clientRepository.saveOrUpdateClient(clientToUpdate);
    }
}
