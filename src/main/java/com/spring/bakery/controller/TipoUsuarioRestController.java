package com.spring.bakery.controller;


import com.spring.bakery.modeloDTO.TipoUsuarioDTO;
import com.spring.bakery.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/tipo_usuario")
public class TipoUsuarioRestController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<ArrayList<TipoUsuarioDTO>> obtenerTipoUsuario(){
        return new ResponseEntity<>(tipoUsuarioService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> obtenerTipoUsuarioPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(tipoUsuarioService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoUsuarioDTO> guardarTipoUsuario(@RequestBody TipoUsuarioDTO TipoUsuarioDTO){
        return new ResponseEntity<>(tipoUsuarioService.guardar(TipoUsuarioDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TipoUsuarioDTO> actualizarTipoUsuario(@RequestBody TipoUsuarioDTO TipoUsuarioDTO){
        return new ResponseEntity<>(tipoUsuarioService.guardar(TipoUsuarioDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoUsuario(@PathVariable(value = "id",required = false) int id){
        tipoUsuarioService.eliminar(id);
        return new ResponseEntity<>("Tipo Usuario eliminado con exito",HttpStatus.OK);
    }

}
