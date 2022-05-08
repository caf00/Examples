package com.alejandro.JPAexampleMtoM.dtos.actor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListMoviesFromActorDto {
    private String actor_name;
    private List<String> movies_name;
}
