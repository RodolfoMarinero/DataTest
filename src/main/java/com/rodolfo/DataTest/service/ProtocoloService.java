package com.rodolfo.DataTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.DataTest.model.Protocolo;
import com.rodolfo.DataTest.repository.ProtocoloRepository;

@Service
public class ProtocoloService {
    @Autowired
    private ProtocoloRepository repository;

    public Protocolo saveUser(Protocolo protocolo) {
        return repository.save(protocolo);
    }

    public Optional<Protocolo> getProtocoloByMatricula(String matricula) {
        return repository.findById(matricula);
    }

    public Iterable<Protocolo> getAllUsers() {
        return repository.findAll();
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
