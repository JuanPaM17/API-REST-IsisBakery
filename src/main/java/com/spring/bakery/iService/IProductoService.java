package com.spring.bakery.iService;

import com.spring.bakery.modeloDTO.ProductoDTO;

import java.util.ArrayList;

public interface IProductoService {

    public ProductoDTO guardar(ProductoDTO ProductoDTO);

    public ArrayList<ProductoDTO> obtener();

    public ProductoDTO buscarId(int id);

    public ProductoDTO actualizar(ProductoDTO ProductoDTO);

    public void eliminar(int id);

}
