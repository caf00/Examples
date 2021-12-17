package com.alejandro.testupdate.web.config;

import com.alejandro.testupdate.db.ClientJpaRepository;
import com.alejandro.testupdate.db.ClientRepositoryImpl;
import com.alejandro.testupdate.core.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Bean
    public CreateClientUseCase createClientUseCase() {
        return new CreateClientUseCaseImpl(new ClientRepositoryImpl(clientJpaRepository));
    }
    @Bean
    public GetAllClientsUseCase getAllClientsUseCase() {
        return new GetAllClientsUseCaseImpl(new ClientRepositoryImpl(clientJpaRepository));
    }
    @Bean
    public UpdateClientUseCase updateClientUseCase() {
        return new UpdateClientUseCaseImpl(new ClientRepositoryImpl(clientJpaRepository));
    }
}
