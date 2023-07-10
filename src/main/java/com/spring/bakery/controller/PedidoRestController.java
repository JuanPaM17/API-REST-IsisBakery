package com.spring.bakery.controller;

import com.spring.bakery.modeloDTO.PedidoDTO;
import com.spring.bakery.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<ArrayList<PedidoDTO>> obtenerPedidos(){
        return new ResponseEntity<>(pedidoService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(
            @PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(pedidoService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping("/{id_cliente}/{id_estado_pedido}")
    public ResponseEntity<PedidoDTO> guardarPedido(
            @RequestBody PedidoDTO pedidoDTO,
            @PathVariable(value="id_estado_pedido",required = false) int id_estado_pedido,
            @PathVariable(value="id_cliente",required = false) int id_cliente){
        return new ResponseEntity<>(pedidoService.guardar(pedidoDTO,id_estado_pedido,id_cliente),HttpStatus.CREATED);
    }

    @PutMapping("/{id_cliente}/{id_estado_pedido}")
    public ResponseEntity<PedidoDTO> actualizarPedido(
            @RequestBody PedidoDTO pedidoDTO,
            @PathVariable(value="id_estado_pedido",required = false) int id_estado_pedido,
            @PathVariable(value="id_cliente",required = false) int id_cliente){
        return new ResponseEntity<>(pedidoService.guardar(pedidoDTO,id_estado_pedido,id_cliente),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPedido(
            @PathVariable(value = "id",required = false) int id){
        pedidoService.eliminar(id);
        return new ResponseEntity<>("Pedido eliminado con exito",HttpStatus.OK);
    }

}
