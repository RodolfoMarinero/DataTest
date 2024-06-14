package com.rodolfo.DataTest.model;

import java.util.Date;

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
public class Tarea {
    @Id
    private int id;
    private String actividad;
    private String estado;
    private Date fecha;
}
