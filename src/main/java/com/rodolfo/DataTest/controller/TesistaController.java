package com.rodolfo.DataTest.controller;

import java.util.Optional;

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


    @PostMapping("/addTesistaRequest")
    public void createTesistaWithRequestBody(@RequestBody Tesista tesista) {
        service.saveUser(tesista);
    }

    @DeleteMapping("deleteTesista/{matricula}")
    public void deleteTesista(@PathVariable String matricula) {
        service.deleteUser(matricula);
    }

    @GetMapping("/findallTesista")
    public Iterable<Tesista> getAllTesista() {
        return service.getAllUsers();
    }
    @PostMapping("/agregarTareaA/{matricula}")
    public Tesista addTareaToTesista(@PathVariable String matricula, @RequestBody Tarea tarea) {
        return service.addTareaToTesista(matricula, tarea);
    }
}
