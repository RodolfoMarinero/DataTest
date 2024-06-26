package com.rodolfo.DataTest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Director {
        @Id
    public String id;
    public String nombre;
    public String apellidos;
    public String area;
    public String universidad;
    public boolean notificacion;
    private String correoElectronico;
    private String contrasena;
}
