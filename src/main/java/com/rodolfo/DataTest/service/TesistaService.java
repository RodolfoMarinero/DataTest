package com.rodolfo.DataTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rodolfo.DataTest.model.Tarea;
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
    
    public Tesista addTareaToTesista(String matricula,Tarea tarea) {
        Optional<Tesista> optionalTesista = repository.findById(matricula);
        if (optionalTesista.isPresent()) {
            Tesista tesista = optionalTesista.get();
            tarea.setTesista(tesista); 
            tesista.getTareas().add(tarea);
            return repository.save(tesista);
        } else {
            throw new RuntimeException("Tesista no encontrado con matrícula: " + matricula);
        }
    }

}

