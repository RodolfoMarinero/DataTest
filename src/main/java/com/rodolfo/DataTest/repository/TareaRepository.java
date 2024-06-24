package com.rodolfo.DataTest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rodolfo.DataTest.model.Tarea;

public interface TareaRepository extends CrudRepository<Tarea,Integer> {
    //Iterable<Tarea> findByTesistaMatricula(String matricula);
}
