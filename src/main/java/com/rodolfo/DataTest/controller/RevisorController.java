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
import com.rodolfo.DataTest.model.Tesista;
import com.rodolfo.DataTest.service.RevisorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RevisorController {
    @Autowired
    private RevisorService service;

    @PostMapping("/addRevisorRequest")
    public void createRevisorWithRequestBody(@RequestBody Revisor revisor) {
        service.saveUser(revisor);
    }

    @DeleteMapping("deleteRevisor/{matricula}")
    public void deleteRevisor(@PathVariable String matricula) {
        service.deleteUser(matricula);
    }

    @GetMapping("/findAllRevisor")
    public Iterable<Revisor> getAllRevisor() {
        return service.getAllUsers();
    }
    
    @GetMapping("/findRevisor/{matricula}")
    public Revisor getRevisor(@PathVariable String matricula) {
        return service.getRevisorByMatricula(matricula).orElse(null);
    }

}
