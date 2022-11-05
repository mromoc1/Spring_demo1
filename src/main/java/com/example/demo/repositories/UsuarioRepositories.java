package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsuarioModel;

@Repository
public interface UsuarioRepositories extends  CrudRepository<UsuarioModel, Long>{
    // interface que implementa ciertos metodos de CrudRepository
    // CrudRepository es una clase que implementa metodos para hacer operaciones CRUD
    // CrudRepository<ClaseModel, Tipo de dato de la llave primaria>
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    // findByCorreo es un metodo que se implementa de la clase CrudRepository

}
