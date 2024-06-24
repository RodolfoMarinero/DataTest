package com.rodolfo.DataTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.DataTest.model.Revisor;
import com.rodolfo.DataTest.service.RevisorService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RevisorController {
@Autowired
    private RevisorService service;

    @PostMapping("/addRevisorPath/{matricula}/{nombre}/{apellidos}/{area}/{universidad}/{email}/{contrasena}/{notificacion}")
    public void createRevisorWithPathVariable(@PathVariable String matricula, @PathVariable String nombre, @PathVariable String apellidos, @PathVariable String area, @PathVariable String universidad, @PathVariable String email, @PathVariable String contrasena, @PathVariable boolean notificacion){
        Revisor a=new Revisor(matricula,nombre,apellidos,area,universidad,email,contrasena,notificacion);
        service.saveUser(a);
    }

    @PostMapping("/addRevisorRequest")  
    public void createRevisorWithRequestBody(@RequestBody Revisor revisor){
        service.saveUser(revisor);
    }

    @DeleteMapping("deleteRevisor/{matricula}")
    public void deleteRevisor(@PathVariable String matricula){
        service.deleteUser(matricula);
    }

    @GetMapping("/findallRevisor")
    public Iterable<Revisor> getAllRevisor() {
        return service.getAllUsers();
    }
}
