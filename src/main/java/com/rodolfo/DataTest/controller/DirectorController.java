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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.DataTest.model.Director;
import com.rodolfo.DataTest.service.DirectorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DirectorController {

    @Autowired
    private DirectorService service;

    @PostMapping("/addDirector")
    public void createDirector(@RequestBody Director director) {
        service.saveDirector(director);
    }

    @PutMapping("/updateDirector/{id}")
    public void updateDirector(@PathVariable String id, @RequestBody Director director) {
        director.setId(id);
        service.updateDirector(director);
    }

    @DeleteMapping("/deleteDirector/{id}")
    public void deleteDirector(@PathVariable String id) {
        service.deleteDirector(id);
    }

    @GetMapping("/findAllDirectors")
    public Iterable<Director> getAllDirectors() {
        return service.getAllDirectors();
    }

    @GetMapping("/findDirector/{id}")
    public Optional<Director> getDirectorById(@PathVariable String id) {
        return service.getDirectorById(id);
    }

    @GetMapping("/findDirectorsByUniversity/{universidad}")
    public Iterable<Director> getDirectorsByUniversity(@PathVariable String universidad) {
        Iterable<Director> allDirectors = this.getAllDirectors();
        List<Director> filteredDirectors = new ArrayList<>();

        for (Director director : allDirectors) {
            if (director.getUniversidad().equals(universidad)) {
                filteredDirectors.add(director);
            }
        }

        return filteredDirectors;
    }

    @GetMapping("/findDirectorsByArea/{area}")
    public Iterable<Director> getDirectorsByArea(@PathVariable String area) {
        Iterable<Director> allDirectors = this.getAllDirectors();
        List<Director> filteredDirectors = new ArrayList<>();

        for (Director director : allDirectors) {
            if (director.getArea().equals(area)) {
                filteredDirectors.add(director);
            }
        }

        return filteredDirectors;
    }
}
