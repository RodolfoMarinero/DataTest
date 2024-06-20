package com.rodolfo.DataTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.DataTest.model.Tarea;
import com.rodolfo.DataTest.service.TareaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {

    @Autowired
    private TareaService service;

    @PostMapping("/addTareaRequest")
    public void createTareaWithRequestBody(@RequestBody Tarea tarea) {
        service.saveTarea(tarea);
    }

    @DeleteMapping("/deleteTarea/{id}")
    public void deleteTarea(@PathVariable int id) {
        service.deleteTarea(id);
    }

    @GetMapping("/findallTarea")
    public Iterable<Tarea> getAllTareas() {
        return service.getAllTareas();
    }
    
    @GetMapping("/filtrarTareas/{matricula}")
    public Iterable<Tarea> filtrarTareasM(@PathVariable String matricula) {
        return service.getTareasByMatricula(matricula);
    }
}
