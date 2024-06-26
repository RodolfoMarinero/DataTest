package com.rodolfo.DataTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.DataTest.model.Director;
import com.rodolfo.DataTest.repository.DirectorRepository;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repository;

    public Director saveDirector(Director director) {
        return repository.save(director);
    }

    public Director updateDirector(Director director) {
        return repository.save(director);
    }

    public Optional<Director> getDirectorById(String id) {
        return repository.findById(id);
    }

    public Iterable<Director> getAllDirectors() {
        return repository.findAll();
    }

    public void deleteDirector(String id) {
        repository.deleteById(id);
    }
}
