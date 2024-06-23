package com.rodolfo.DataTest.controller;


import java.util.Optional;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/filtroPorRevisor/{matricula}")
        public Iterable<Tesista> getTesistaByRevisor(@PathVariable String matricula) {
        Iterable<Tesista> allTesistas = this.getAllTesista();
        List<Tesista> filteredTesistas = new ArrayList<>();
        
        for (Tesista tesista : allTesistas) {
            if (tesista.getRevisor1().equals(matricula) || tesista.getRevisor2().equals(matricula)) {
                filteredTesistas.add(tesista);
            }
        }
        
        return filteredTesistas;
    }

    @GetMapping("/filtroPorDirector/{matricula}")
    public Iterable<Tesista> getTesistaByMatricula(@PathVariable String matricula) {
        Iterable<Tesista> allTesistas = this.getAllTesista();
        List<Tesista> filteredTesistas = new ArrayList<>();
        
        for (Tesista tesista : allTesistas) {
            if (tesista.getDirectorTesis().equals(matricula)) {
                filteredTesistas.add(tesista);
            }
        }
        
        return filteredTesistas;
    }

    @GetMapping("/filtroPorJefe/{carrera}")
    public Iterable<Tesista> getTesistaByJefe(@PathVariable String carrera) {
        Iterable<Tesista> allTesistas = this.getAllTesista();
        List<Tesista> filteredTesistas = new ArrayList<>();
        
        for (Tesista tesista : allTesistas) {
            if (tesista.getCarrera().equals(carrera)) {
                filteredTesistas.add(tesista);
            }
        }
        
        return filteredTesistas;
    
    }

    

}
