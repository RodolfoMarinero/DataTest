package com.rodolfo.DataTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.DataTest.model.Revisor;
import com.rodolfo.DataTest.repository.RevisorRepository;

@Service
public class RevisorService {
    @Autowired
    private RevisorRepository repository;

    public Revisor saveUser(Revisor revisor) {
        return repository.save(revisor);
    }

    public Optional<Revisor> getRevisorByMatricula(String matricula) {
        return repository.findById(matricula);
    }

    public Iterable<Revisor> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}