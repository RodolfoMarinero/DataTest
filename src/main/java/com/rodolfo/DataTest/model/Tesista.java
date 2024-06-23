package com.rodolfo.DataTest.model;

//import java.sql.Date;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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
    private Date fechaInicio;
    private Date fechaFinal;
    private String correoElectronico;
    private String contrasena;
    private boolean notificacion;
    private String revisor1;
    private String revisor2;

    @OneToMany(mappedBy = "tesista", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tarea> tareas = new HashSet<>();


    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
        tarea.setTesista(this);
    }

    // Método auxiliar para remover tareas
    public void removeTarea(Tarea tarea) {
        tareas.remove(tarea);
        tarea.setTesista(null);
    }
}
