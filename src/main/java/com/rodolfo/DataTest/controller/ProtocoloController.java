package com.rodolfo.DataTest.controller;

import java.util.Date;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.DataTest.model.Protocolo;
import com.rodolfo.DataTest.service.ProtocoloService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProtocoloController {
    @Autowired
    private ProtocoloService service;

    @PostMapping("/addProtocoloPath/{matricula}/{nombre}/{apellidos}/{carrera}/{tituloTesis}/{directorTesis}/{codirectorTesis}")
    public void createProtocoloWithPathVariable(@PathVariable String matricula, @PathVariable String nombre, @PathVariable String apellidos, @PathVariable String carrera, @PathVariable String tituloTesis, @PathVariable String directorTesis, @PathVariable String codirectorTesis){
        Protocolo a=new Protocolo(matricula,nombre,apellidos,carrera,tituloTesis,directorTesis,codirectorTesis);
        service.saveUser(a);
    }

    @PostMapping("/addProtocoloRequest")  
    public void createProtocoloWithRequestBody(@RequestBody Protocolo protocolo){
        service.saveUser(protocolo);
    }

    @DeleteMapping("deleteProtocolo/{matricula}")
    public void deleteProtocolo(@PathVariable String matricula){
        service.deleteUser(matricula);
    }

    @GetMapping("/findallProtocolo")
    public Iterable<Protocolo> getAllProtocolo() {
        return service.getAllUsers();
    }
}
