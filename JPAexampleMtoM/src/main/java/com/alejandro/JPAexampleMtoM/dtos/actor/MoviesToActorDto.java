package com.alejandro.JPAexampleMtoM.dtos.actor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MoviesToActorDto {
    private Set<Integer> movies_id;
}
