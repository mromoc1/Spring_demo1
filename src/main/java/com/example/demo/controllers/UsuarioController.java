package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/usuario")
// @RequestMapping es una anotacion que indica la ruta de la clase
public class UsuarioController {
    // RestController es una anotacion que indica que es una clase controladora
    // RestController es una clase que se encarga de recibir las peticiones HTTP
    // RestController es una clase que se encarga de enviar las respuestas HTTP
    @Autowired
    UsuarioServices usuarioService;

    @GetMapping()
    // Cuando llegue una peticion de tipo GET a la ruta /usuario, ejecuta estas funcionalidades
    // @GetMapping es una anotacion que indica que es un metodo que responde a una peticion GET
    // @GetMapping(value="path") es una anotacion que indica que es un metodo que responde a una peticion GET en la ruta /usuario/path
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }


    @PostMapping()
    // @PostMapping es una anotacion que indica que es un metodo que responde a una peticion POST
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        // Todos los clientes pueden enviar informacion dentro del cuerpo de la solicitud HTTP
        // @RequestBody es una anotacion que indica que el objeto que se recibe como parametro es el cuerpo de la solicitud HTTP
        return this.usuarioService.guardarUsuario(usuario);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        // @PathVariable es una anotacion que indica que el objeto que se recibe como parametro es un parametro de la ruta
        return this.usuarioService.obtenerPorId(id);
    }
    
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        // @RequestParam es una anotacion que indica que el objeto que se recibe como parametro es un parametro de la URL
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id " + id;
        }
    }

}
