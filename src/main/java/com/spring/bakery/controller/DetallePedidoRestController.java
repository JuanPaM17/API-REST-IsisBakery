package com.spring.bakery.controller;

import com.spring.bakery.modeloDTO.DetallePedidoDTO;
import com.spring.bakery.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/pedido/detalle")
public class DetallePedidoRestController {

    @Autowired
    private DetallePedidoService detallePedidoService;


    @GetMapping
    public ResponseEntity<ArrayList<DetallePedidoDTO>> obtenerDetallePedido(){
        return new ResponseEntity<>(detallePedidoService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> obtenerVentaPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(detallePedidoService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping("/{id_pedido}/{id_producto}")
    public ResponseEntity<DetallePedidoDTO> guardarDetallePedido(
            @RequestBody DetallePedidoDTO DetallePedidoDTO,
            @PathVariable(value="id_pedido",required = true) int id_pedido,
            @PathVariable(value="id_producto",required = true) int id_producto){
        return new ResponseEntity<>(detallePedidoService.guardar(DetallePedidoDTO,id_pedido,id_producto),HttpStatus.CREATED);
    }

    @PutMapping("/{id_pedido}/{id_producto}")
    public ResponseEntity<DetallePedidoDTO> actualizarDetallePedido(
            @RequestBody DetallePedidoDTO DetallePedidoDTO,
            @PathVariable(value="id_pedido",required = true) int id_pedido,
            @PathVariable(value="id_producto",required = true) int id_producto){
        return new ResponseEntity<>(detallePedidoService.guardar(DetallePedidoDTO,id_pedido,id_producto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDetallePedido(@PathVariable(value = "id",required = false) int id){
        detallePedidoService.eliminar(id);
        return new ResponseEntity<>("Pedido eliminado con exito",HttpStatus.OK);
    }


}
