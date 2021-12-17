package com.alejandro.testupdate.core.usecase;

import com.alejandro.testupdate.core.domain.Client;

import java.util.List;

public interface GetAllClientsUseCase {
    List<Client> execute();
}
