package com.rodolfo.DataTest.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addJefatura")
    public void createJefatura(@RequestBody Jefatura jefatura) {
        service.saveUser(jefatura);
    }

    @DeleteMapping("/deleteJefatura/{id}")
    public void deleteJefatura(@PathVariable String id) {
        service.deleteUser(id);
    }

    @GetMapping("/findAllJefaturas")
    public Iterable<Jefatura> getAllJefaturas() {
        return service.getAllUsers();
    }

    @GetMapping("/findJefatura/{id}")
    public Optional<Jefatura> getJefaturaById(@PathVariable String id) {
        return service.getJefaturaById(id);
    }


}
