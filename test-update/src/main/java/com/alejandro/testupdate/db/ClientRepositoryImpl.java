package com.alejandro.testupdate.db;

import com.alejandro.testupdate.core.domain.Client;
import com.alejandro.testupdate.core.domain.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;

    public ClientRepositoryImpl(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientJpaRepository.findAll()
                .stream()
                .map(ClientDb::toClient)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findClientById(Integer id) {
        return this.clientJpaRepository.findById(id).map(ClientDb::toClient);
    }

    @Override
    public Client saveOrUpdateClient(Client client) {
        ClientDb clientDb = this.clientJpaRepository.save(new ClientDb(client));
        return clientDb.toClient();
    }

    @Override
    public boolean existClient(Integer id) {
        return this.clientJpaRepository.existsById(id);
    }
}
