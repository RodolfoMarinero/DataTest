package com.rodolfo.DataTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.DataTest.model.Tesista;
import com.rodolfo.DataTest.repository.TesistaRepository;

@Service
public class TesistaService {
    @Autowired
    private TesistaRepository repository;

    public Tesista saveUser(Tesista tesista) {
        return repository.save(tesista);
    }

    public Optional<Tesista> getTesistaByMatricula(String matricula) {
        return repository.findById(matricula);
    }

    public Iterable<Tesista> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
