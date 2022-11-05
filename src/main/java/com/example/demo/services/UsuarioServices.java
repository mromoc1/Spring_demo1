package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepositories;

@Service
public class UsuarioServices {
    // @Service es una anotacion que indica que es una clase de servicio
    // @Autowired es una anotacion que indica que se va a inyectar una dependencia
    @Autowired
    UsuarioRepositories usuarioRepositories;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepositories.findAll();
        // findAll() es un metodo de CrudRepository que devuelve todos los registros de la tabla
        // (ArrayList<UsuarioModel>) es un casting que convierte el resultado de findAll() a un ArrayList de UsuarioModel
    }
    
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepositories.save(usuario);
        // save() es un metodo de CrudRepository que guarda un registro en la tabla
        // save() recibe un objeto de la clase UsuarioModel
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        // Optional es una clase que permite manejar valores nulos
        return usuarioRepositories.findById(id);
        // findById() es un metodo de CrudRepository que busca un registro por su llave primaria
        // findById() recibe un Long que es el id del registro a buscar
        // retorna un Optional<UsuarioModel> que es un objeto que puede o no contener un UsuarioModel
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepositories.findByPrioridad(prioridad);
        // findByPrioridad() es un metodo que se implementa en UsuarioRepositories
        // findByPrioridad() recibe un Integer que es la prioridad a buscar
        // retorna un ArrayList<UsuarioModel> que es un objeto que puede o no contener un UsuarioModel
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepositories.deleteById(id);
            // deleteById() es un metodo de CrudRepository que elimina un registro por su llave primaria
            // deleteById() recibe un Long que es el id del registro a eliminar
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
