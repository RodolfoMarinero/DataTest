package com.rodolfo.DataTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.DataTest.model.Jefatura;
import com.rodolfo.DataTest.service.JefaturaService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JefaturaController {
    @Autowired
    private JefaturaService service;

    @PostMapping("/addJefaturaPath/{id}/{nombre}/{apellidos}/{carrera}/{universidad}/{email}/{contrasena}")
    public void createJefaturaWithPathVariable(@PathVariable String id, @PathVariable String nombre, @PathVariable String apellidos, @PathVariable String carrera, @PathVariable String universidad, @PathVariable String email, @PathVariable String contrasena){
        Jefatura a=new Jefatura(id,nombre,apellidos,carrera,universidad,email,contrasena);
        service.saveUser(a);
    }

    @PostMapping("/addJefaturaRequest")  
    public void createJefaturaWithRequestBody(@RequestBody Jefatura jefatura){
        service.saveUser(jefatura);
    }

    @DeleteMapping("deleteJefatura/{id}")
    public void deleteJefatura(@PathVariable String id){
        service.deleteUser(id);
    }

    @GetMapping("/findallJefatura")
    public Iterable<Jefatura> getAllJefatura() {
        return service.getAllUsers();
    }
}
