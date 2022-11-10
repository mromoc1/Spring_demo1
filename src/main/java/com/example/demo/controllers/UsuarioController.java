package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    // @Autowired es una anotacion que indica que se va a inyectar una dependencia
    
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    @GetMapping()
    // Cuando llegue una peticion de tipo GET a la ruta /usuario, ejecuta estas funcionalidades
    // @GetMapping es una anotacion que indica que es un metodo que responde a una peticion GET
    // @GetMapping(value="path") es una anotacion que indica que es un metodo que responde a una peticion GET en la ruta /usuario/path
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        try {
            log.info("Se obtuvieron todos los usuarios");
            return usuarioService.obtenerUsuarios();
        } catch (Exception e) {
            log.error("Error al obtener usuarios => ", e.getMessage());
            return null;
        }
    }

    @PostMapping()
    // @PostMapping es una anotacion que indica que es un metodo que responde a una peticion POST
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        // Todos los clientes pueden enviar informacion dentro del cuerpo de la solicitud HTTP
        // @RequestBody es una anotacion que indica que el objeto que se recibe como parametro es el cuerpo de la solicitud HTTP
        try {
            log.info("Se guardo el usuario: " + usuario.getNombre()+ " cuyo correo es: " + usuario.getCorreo()+ " con una prioridad de:" + usuario.getPrioridad());
            return this.usuarioService.guardarUsuario(usuario);
        } catch (Exception e) {
            log.error("Error al guardar el usuario => " + e.getMessage());
            return null;
        }
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Object id) {
        // @PathVariable es una anotacion que indica que el objeto que se recibe como parametro es un parametro de la ruta
        try {
            log.info("Se obtuvo el usuario con id: " + (Long)id);
            return this.usuarioService.obtenerPorId((Long)id);
        } catch (Exception e) {
            log.error("Error al obtener el usuario => " + e.getMessage());
            return null;
        }
    }
    
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Object prioridad) {
        // @RequestParam es una anotacion que indica que el objeto que se recibe como parametro es un parametro de la URL
        try {
            log.info("Se obtuvo la lista de usuario con prioridad: " + (Integer)prioridad);
            return this.usuarioService.obtenerPorPrioridad((Integer)prioridad);
        } catch (Exception e) {
            log.error("Error al obtener la lista de usuarios => " + e.getMessage());
            return null;
        }
    }

    @DeleteMapping(path = "/{id}")
    // @DeleteMapping es una anotacion que indica que es un metodo que responde a una peticion DELETE
    public String eliminarPorId(@PathVariable("id") Object id) {
        try {
            boolean ok = this.usuarioService.eliminarUsuario((Long) id);
            if (ok) {
                log.info("Se elimino el usuario con id: " + (Long)id);
                return "Se elimino el usuario con id: " + (Long)id;
            } else {
                log.info("No se pudo eliminar el usuario con id: " + (Long)id);
                return "No se pudo eliminar el usuario con id: " + (Long)id;
            }
        } catch (Exception e) {
            log.error("Error al eliminar el usuario => " + e.getMessage());
            return "Error al eliminar el usuario: " + e.getMessage();
        }
    }

}
