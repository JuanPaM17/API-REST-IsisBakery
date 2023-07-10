package com.spring.bakery.controller;


import com.spring.bakery.modeloDTO.EstadoPedidoDTO;
import com.spring.bakery.service.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/estado_pedido")
public class EstadoPedidoRestController {

    @Autowired
    private EstadoPedidoService estadoPedidoService;

    @GetMapping
    public ResponseEntity<ArrayList<EstadoPedidoDTO>> obtenerEstadoPedidos(){
        return new ResponseEntity<>(estadoPedidoService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedidoDTO> obtenerEstadoPedidoPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(estadoPedidoService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoPedidoDTO> guardarEstadoPedido(@RequestBody EstadoPedidoDTO estadoPedidoDTO){
        return new ResponseEntity<>(estadoPedidoService.guardar(estadoPedidoDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstadoPedidoDTO> actualizarEstadoPedido(@RequestBody EstadoPedidoDTO estadoPedidoDTO){
        return new ResponseEntity<>(estadoPedidoService.guardar(estadoPedidoDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstadoPedido(@PathVariable(value = "id",required = false) int id){
        estadoPedidoService.eliminar(id);
        return new ResponseEntity<>("Estado Pedido eliminado con exito",HttpStatus.OK);
    }
}
