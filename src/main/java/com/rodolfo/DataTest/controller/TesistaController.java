package com.rodolfo.DataTest.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.DataTest.model.Tarea;
import com.rodolfo.DataTest.model.Tesista;
import com.rodolfo.DataTest.service.TesistaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TesistaController {

    @Autowired
    private TesistaService service;

    @PostMapping("/addTesistaPath/{matricula}/{nombre}/{apellidos}/{carrera}/{tituloTesis}/{directorTesis}/{codirectorTesis}/{fechaInicio}/{fechaFinal}/{correoElectronico}/{contrasena}/{notificacion}/{revisor1}/{revisor2}/{tareas}")
    public void createTesistaWithPathVariable(@PathVariable String matricula, @PathVariable String nombre, @PathVariable String apellidos, @PathVariable String carrera, @PathVariable String tituloTesis, @PathVariable String directorTesis, @PathVariable String codirectorTesis, @PathVariable String fechaInicio, @PathVariable String fechaFinal, @PathVariable String correoElectrinico, @PathVariable String contrasena, @PathVariable boolean notificacion, @PathVariable String revisor1, @PathVariable String revisor2){
        Tesista a=new Tesista(matricula,nombre,apellidos,carrera,tituloTesis,directorTesis,codirectorTesis,fechaInicio,fechaFinal,correoElectrinico,contrasena,notificacion,revisor1,revisor2);
        service.saveUser(a);
    }

    @PostMapping("/addTesistaRequest")  
    public void createTesistaWithRequestBody(@RequestBody Tesista tesista){
        service.saveUser(tesista);
    }

    @DeleteMapping("deleteTesista/{matricula}")
    public void deleteTesista(@PathVariable String matricula){
        service.deleteUser(matricula);
    }

    @GetMapping("/findallTesista")
    public Iterable<Tesista> getAllTesista() {
        return service.getAllUsers();
    }
}
