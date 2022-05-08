package com.alejandro.exampledto.controller.response;

import java.io.Serializable;

public class MessageResponse implements Serializable {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
