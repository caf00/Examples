package com.alejandro.exampledto.controller;

import com.alejandro.exampledto.controller.request.CreateContactRequest;
import com.alejandro.exampledto.controller.response.ContactResponse;
import com.alejandro.exampledto.controller.response.MessageResponse;
import com.alejandro.exampledto.service.dto.ContactDto;
import com.alejandro.exampledto.service.ListContactService;
import com.alejandro.exampledto.service.SaveContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ListContactService listContactService;
    private final SaveContactService saveContactService;

    @Autowired
    public ContactController(ListContactService listContactService,
                             SaveContactService saveContactService) {
        this.listContactService = listContactService;
        this.saveContactService = saveContactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll() {
        List<ContactResponse> list = listContactService
                .list()
                .stream()
                .map(c->new ContactResponse(
                        c.getId(),
                        c.getName(),
                        c.getLastName(),
                        c.getAddress(),
                        c.getPhone()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> save(@RequestBody CreateContactRequest createContactRequest) {
        saveContactService.save(new ContactDto(
                null,
                createContactRequest.getLastName(),
                createContactRequest.getLastName(),
                createContactRequest.getAddress(),
                createContactRequest.getPhone()
        ));
        return ResponseEntity.ok(new MessageResponse("Contact created successfully"));
    }
}
