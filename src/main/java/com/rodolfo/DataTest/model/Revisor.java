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
public class Revisor {
    @Id
    public String matricula;
    public String nombre;
    public String apellidos;
    public String area;
    public String universidad;
    public String email;
    public String contrasena;
    public boolean notificacion;
}
