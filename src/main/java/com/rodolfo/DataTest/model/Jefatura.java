package com.rodolfo.DataTest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@Entity
public class Jefatura {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String carrera;
    private String universidad;
    private String email;
}
