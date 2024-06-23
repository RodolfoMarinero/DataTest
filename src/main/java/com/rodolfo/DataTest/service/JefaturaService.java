package com.rodolfo.DataTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.DataTest.model.Jefatura;
import com.rodolfo.DataTest.repository.JefaturaRepository;

@Service
public class JefaturaService {

    @Autowired
    private JefaturaRepository repository;

    public Jefatura saveUser(Jefatura jefatura) {
        return repository.save(jefatura);
    }

    public Optional<Jefatura> getJefaturaById(String id) {
        return repository.findById(id);
    }

    public Iterable<Jefatura> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }

}
