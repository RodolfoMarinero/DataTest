package com.rodolfo.DataTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfo.DataTest.model.Tarea;
import com.rodolfo.DataTest.repository.TareaRepository;

@Service
public class TareaService {
    @Autowired
    private TareaRepository repository;

    public Tarea saveTarea(Tarea tarea) {
        return repository.save(tarea);
    }

    public Optional<Tarea> getTareaById(int id) {
        return repository.findById(id);
    }

    public Iterable<Tarea> getAllTareas() {
        return repository.findAll();
    }

    public void deleteTarea(int id) {
        repository.deleteById(id);
    }

    public Iterable<Tarea> getTareasByMatricula(String matricula) {
        List<Tarea> filteredTareas = new ArrayList<>();
        for (Tarea tarea : this.getAllTareas()) {
            if (tarea.getTesista().getMatricula().equals(matricula)) {
                filteredTareas.add(tarea);
            }
        }
        return filteredTareas;
    }

}
