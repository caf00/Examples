package ar.alexdev.profileexample;

import java.time.LocalDate;
import java.util.UUID;

public class Message {
    private UUID id;
    private String message;
    private LocalDate date;
    
    public Message(UUID id, String message, LocalDate date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public static Message newInstance(UUID id, String message, LocalDate date) {
        return new Message(id, message, date);
    }

    public UUID getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public LocalDate getDate() {
        return date;
    }
}
