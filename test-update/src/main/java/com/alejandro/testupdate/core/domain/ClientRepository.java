package com.alejandro.testupdate.core.domain;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAllClients();
    Optional<Client> findClientById(Integer id);
    Client saveOrUpdateClient(Client client);
    boolean existClient(Integer id);
}
