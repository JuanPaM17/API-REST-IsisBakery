package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IProductoRepository;
import com.spring.bakery.iService.IProductoService;
import com.spring.bakery.modelo.Producto;
import com.spring.bakery.modelo.Usuario;
import com.spring.bakery.modeloDTO.ProductoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service

public class ProductoService implements IProductoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public ProductoDTO guardar(ProductoDTO productoDTO) {
        return mapearDTO(iProductoRepository.save(mapearClase(productoDTO)));
    }

    @Override
    public ArrayList<ProductoDTO> obtener() {
        ArrayList<Producto> listaProductos = (ArrayList<Producto>) iProductoRepository.findAll();
        return (ArrayList<ProductoDTO>) listaProductos.stream().map(producto ->
                    mapearDTO(producto)
                ).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO buscarId(int id) {
        Producto producto = iProductoRepository.findById(id)
                .orElseThrow(()-> new ResourceNoFound("Producto","Id",id));
        return mapearDTO(producto);
    }

    @Override
    public ProductoDTO actualizar(ProductoDTO productoDTO) {
        Producto producto = iProductoRepository.findById(productoDTO.getId())
                .orElseThrow(()-> new ResourceNoFound("Producto","Id",productoDTO.getId()));
        return mapearDTO(producto);
    }

    @Override
    public void eliminar(int id) {
        Producto producto = iProductoRepository.findById(id)
                .orElseThrow(()-> new ResourceNoFound("Producto","Id",id));
        iProductoRepository.delete(producto);
    }

    private ProductoDTO mapearDTO(Producto producto){
        return modelMapper.map(producto,ProductoDTO.class);
    }

    private Producto mapearClase(ProductoDTO productoDTO){
        return modelMapper.map(productoDTO,Producto.class);
    }

}
