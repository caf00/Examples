package com.aleDev.democriteriaAPI;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
}
