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

import com.rodolfo.DataTest.model.Director;
import com.rodolfo.DataTest.model.Jefatura;
import com.rodolfo.DataTest.model.Revisor;
import com.rodolfo.DataTest.model.Tesista;
import com.rodolfo.DataTest.service.DirectorService;
import com.rodolfo.DataTest.service.JefaturaService;
import com.rodolfo.DataTest.service.RevisorService;
import com.rodolfo.DataTest.service.TesistaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TesistaController {

    @Autowired
    private TesistaService tesistaService;

    @Autowired
    private RevisorService revisorService;

    @Autowired
    private JefaturaService jefaturaService;

    @Autowired
    private DirectorService directorService;

    @PostMapping("/addTesistaRequest")
    public void createTesistaWithRequestBody(@RequestBody Tesista tesista) {
        tesistaService.saveUser(tesista);
    }

    @DeleteMapping("/deleteTesista/{matricula}")
    public void deleteTesista(@PathVariable String matricula) {
        tesistaService.deleteUser(matricula);
    }

    @GetMapping("/findallTesista")
    public Iterable<Tesista> getAllTesista() {
        return tesistaService.getAllUsers();
    }

    @GetMapping("/findTesista/{matricula}")
    public Optional<Tesista> getTesista(@PathVariable String matricula) {
        return tesistaService.getTesistaByMatricula(matricula);
    }

    @GetMapping("/filtroPorRevisor/{matricula}")
    public Iterable<Tesista> getTesistaByRevisor(@PathVariable String matricula) {
        Iterable<Tesista> allTesistas = tesistaService.getAllUsers();
        List<Tesista> filteredTesistas = new ArrayList<>();

        for (Tesista tesista : allTesistas) {
            if (tesista.getRevisor1().equals(matricula) || tesista.getRevisor2().equals(matricula)) {
                filteredTesistas.add(tesista);
            }
        }

        return filteredTesistas;
    }

    @GetMapping("/filtroPorDirector/{matricula}")
    public Iterable<Tesista> getTesistaByDirector(@PathVariable String matricula) {
        Iterable<Tesista> allTesistas = tesistaService.getAllUsers();
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
        Iterable<Tesista> allTesistas = tesistaService.getAllUsers();
        List<Tesista> filteredTesistas = new ArrayList<>();

        for (Tesista tesista : allTesistas) {
            if (tesista.getCarrera().equals(carrera)) {
                filteredTesistas.add(tesista);
            }
        }

        return filteredTesistas;
    }

    @GetMapping("/getRevisor/{matricula}")
    public Revisor getRevisorDelTesista(@PathVariable String matricula) {
        Iterable<Revisor> allRevisores = revisorService.getAllUsers();
        Revisor filteredRevisor = null;
        for (Revisor revisor : allRevisores) {
            if (revisor.getMatricula().equals(matricula)) {
                filteredRevisor = revisor;
            }
        }
        return filteredRevisor;
    }

    @GetMapping("/getJefatura/{carrera}")
    public Jefatura getJefaturaDelTesista(@PathVariable String carrera) {
        Iterable<Jefatura> allJefaturas = jefaturaService.getAllUsers();
        Jefatura filteredJefatura = null;

        for (Jefatura jefatura : allJefaturas) {
            if (jefatura.getCarrera().equals(carrera)) {
                filteredJefatura = jefatura;
            }
        }

        return filteredJefatura;
    }

    @GetMapping("/getDirector/{matricula}")
    public Director getDirectorDelTesista(@PathVariable String matricula) {
        Iterable<Director> allDirectores = directorService.getAllDirectors();
        Director filteredDirector = null;

        for (Director director : allDirectores) {
            if (director.getId().equals(matricula)) {
                filteredDirector = director;
            }
        }

        return filteredDirector;
    }
}
