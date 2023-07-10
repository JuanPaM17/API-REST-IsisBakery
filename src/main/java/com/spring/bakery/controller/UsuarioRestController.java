package com.spring.bakery.controller;

import com.spring.bakery.modeloDTO.*;
import com.spring.bakery.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<ArrayList<UsuarioDTO>> obtenerUsuario(){
        return new ResponseEntity<>(usuarioService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(usuarioService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping("/{id_estado_usuario}/{id_tipo_usuario}")
    public ResponseEntity<UsuarioDTO> guardarUsuario(
            @RequestBody UsuarioDTO usuarioDTO,
            @PathVariable(value="id_estado_usuario",required = false) int id_estado_usuario,
            @PathVariable(value="id_tipo_usuario",required = false) int id_tipo_usuario){
        return new ResponseEntity<>(usuarioService.guardar(usuarioDTO,id_estado_usuario,id_tipo_usuario),HttpStatus.CREATED);
    }

    @PutMapping("/{id_estado_usuario}/{id_tipo_usuario}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(
            @RequestBody UsuarioDTO UsuarioDTO,
            @PathVariable(value="id_estado_usuario",required = false) int id_estado_usuario,
            @PathVariable(value="id_tipo_usuario",required = false) int id_tipo_usuario){
        return new ResponseEntity<>(usuarioService.guardar(UsuarioDTO,id_estado_usuario,id_tipo_usuario),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable(value = "id",required = false) int id){
        usuarioService.eliminar(id);
        return new ResponseEntity<>("Usuario eliminado con exito",HttpStatus.OK);
    }

}
