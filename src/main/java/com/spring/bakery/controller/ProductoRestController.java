package com.spring.bakery.controller;

import com.spring.bakery.iService.IProductoService;
import com.spring.bakery.modeloDTO.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping
    public ResponseEntity<ArrayList<ProductoDTO>> obtenerProductos(){
        return new ResponseEntity<>(iProductoService.obtener(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable(value = "id",required = false)int id){
        return new ResponseEntity<>(iProductoService.buscarId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> guardarProducto(@RequestBody ProductoDTO ProductoDTO){
        return new ResponseEntity<>(iProductoService.guardar(ProductoDTO),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoDTO ProductoDTO){
        return new ResponseEntity<>(iProductoService.guardar(ProductoDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable(value = "id",required = false) int id){
        iProductoService.eliminar(id);
        return new ResponseEntity<>("Producto eliminado con exito",HttpStatus.OK);
    }

}
