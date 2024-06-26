package com.rodolfo.DataTest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rodolfo.DataTest.model.Director;

public interface DirectorRepository extends CrudRepository<Director,String> {
    
}
