package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    @GetMapping("/buscar/{email}")
    public ArrayList<UsuarioModel> obtenerPorCorreo(@PathVariable("email") String email) {
        return this.usuarioService.obtenerPorCorreo(email);
    }


     @DeleteMapping(path = "/eliminar/{email}")
     public String eliminarPorEmail(@PathVariable("email") String email) {
         boolean ok = this.usuarioService.eliminarUsuarioPorCorreo(email);
         if (ok) {
             return "Se eliminó el usuario con correo " + email;
         } else {
             return "No pudo eliminar el usuario con correo" + email;
         }
     }
}