package com.alejandro.JPAexampleMtoM.dtos.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private String name;
}
