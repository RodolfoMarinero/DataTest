package com.rodolfo.DataTest.model;

import java.util.ArrayList;

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
public class Tesista {
    @Id
    private String matricula;
    private String nombre;
    private String apellidos;
    private String carrera;
    private String tituloTesis;
    private String directorTesis;
    private String codirectorTesis;
    private String fechaInicio;
    private String fechaFinal;
    private String correoElectronico;
    private String contrasena;
    private boolean notificacion;
    private String revisor1;
    private String revisor2;
    //private ArrayList<Tarea> tareas;
}
