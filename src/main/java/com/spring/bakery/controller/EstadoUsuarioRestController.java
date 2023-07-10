package com.spring.bakery.controller;

import com.spring.bakery.modeloDTO.EstadoUsuarioDTO;
import com.spring.bakery.service.EstadoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/estado_usuario")
public class EstadoUsuarioRestController {

    @Autowired
    private EstadoUsuarioService estadoUsuarioService;

    @GetMapping
    public ResponseEntity<ArrayList<EstadoUsuarioDTO>> obtenerEstadoUsuario(){
        return new ResponseEntity<>(estadoUsuarioService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoUsuarioDTO> obtenerEstadoUsuarioPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(estadoUsuarioService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoUsuarioDTO> guardarEstadoUsuario(@RequestBody EstadoUsuarioDTO EstadoUsuarioDTO){
        return new ResponseEntity<>(estadoUsuarioService.guardar(EstadoUsuarioDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstadoUsuarioDTO> actualizarEstadoUsuario(@RequestBody EstadoUsuarioDTO EstadoUsuarioDTO){
        return new ResponseEntity<>(estadoUsuarioService.guardar(EstadoUsuarioDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstadoUsuario(@PathVariable(value = "id",required = false) int id){
        estadoUsuarioService.eliminar(id);
        return new ResponseEntity<>("Estado Usuario eliminado con exito",HttpStatus.OK);
    }
}
