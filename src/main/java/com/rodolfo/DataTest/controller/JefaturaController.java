package com.rodolfo.DataTest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
