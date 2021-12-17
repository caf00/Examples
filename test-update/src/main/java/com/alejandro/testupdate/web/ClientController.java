package com.alejandro.testupdate.web;

import com.alejandro.testupdate.core.domain.Client;
import com.alejandro.testupdate.core.usecase.CreateClientUseCase;
import com.alejandro.testupdate.core.usecase.GetAllClientsUseCase;
import com.alejandro.testupdate.core.usecase.UpdateClientUseCase;
import com.alejandro.testupdate.web.request.CreateClientRequest;
import com.alejandro.testupdate.web.request.UpdateClientRequest;
import com.alejandro.testupdate.web.response.ClientResponse;
import com.alejandro.testupdate.web.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final CreateClientUseCase createClientUseCase;
    private final GetAllClientsUseCase getAllClientsUseCase;
    private final UpdateClientUseCase updateClientUseCase;

    @Autowired
    public ClientController(CreateClientUseCase createClientUseCase, GetAllClientsUseCase getAllClientsUseCase, UpdateClientUseCase updateClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.getAllClientsUseCase = getAllClientsUseCase;
        this.updateClientUseCase = updateClientUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clientResponses= this.getAllClientsUseCase.execute()
                .stream()
                .map(ClientResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientResponses);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> saveClient(@RequestBody CreateClientRequest createClientRequest) {
        Client client = this.createClientUseCase.execute(new Client(
                createClientRequest.getName(),
                createClientRequest.getLastName(),
                createClientRequest.getCity(),
                createClientRequest.getAddress(),
                createClientRequest.getEmail(),
                createClientRequest.getPhone()
        ));
        return ResponseEntity.ok(new MessageResponse(client));
    }
    @PutMapping
    public ResponseEntity<MessageResponse> updateClient(@RequestBody UpdateClientRequest updateClientRequest) {
        Client client = this.updateClientUseCase.execute(new Client(
                updateClientRequest.getId(),
                updateClientRequest.getName(),
                updateClientRequest.getLastName(),
                updateClientRequest.getCity(),
                updateClientRequest.getAddress(),
                updateClientRequest.getEmail(),
                updateClientRequest.getPhone()
        ));
        return ResponseEntity.ok(new MessageResponse(client));
    }
}
