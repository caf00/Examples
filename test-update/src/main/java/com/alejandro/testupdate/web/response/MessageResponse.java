package com.alejandro.testupdate.web.response;

import com.alejandro.testupdate.core.domain.Client;

public class MessageResponse {
    private final String message;

    public MessageResponse(String message) {
        this.message = message;
    }
    public MessageResponse(Client client) {
        this.message = client.toString();
    }

    public String getMessage() {
        return message;
    }
}
