package com.spring.bakery.controller;


import com.spring.bakery.modeloDTO.VentaDTO;
import com.spring.bakery.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/venta")
public class VentaRestController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<ArrayList<VentaDTO>> obtenerVentas(){
        return new ResponseEntity<>(ventaService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO> obtenerVentaPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(ventaService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping("/{id_pedido}/{id_vendedor}")
    public ResponseEntity<VentaDTO> guardarVenta(
            @Valid @RequestBody VentaDTO VentaDTO,
            @PathVariable(value="id_pedido",required = true) int id_pedido,
            @PathVariable(value="id_vendedor",required = true) int id_vendedor){
        return new ResponseEntity<>(ventaService.guardar(VentaDTO,id_pedido,id_vendedor),HttpStatus.CREATED);
    }

    @PutMapping("/{id_pedido}/{id_vendedor}")
    public ResponseEntity<VentaDTO> actualizarVenta(
            @Valid @RequestBody VentaDTO VentaDTO,
            @PathVariable(value="id_pedido",required = true) int id_pedido,
            @PathVariable(value="id_vendedor",required = true) int id_vendedor){
        return new ResponseEntity<>(ventaService.guardar(VentaDTO,id_pedido,id_vendedor),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVenta(@PathVariable(value = "id",required = false) int id){
        ventaService.eliminar(id);
        return new ResponseEntity<>("Venta eliminada con exito",HttpStatus.OK);
    }

}
